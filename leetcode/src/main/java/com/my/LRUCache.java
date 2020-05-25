package com.my;

import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @description:146. LRU缓存机制
 * @Date: 2020/5/25 22:12
 **/
public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        DLinkedNode dLinkedNode = cache.get(key);
        if(dLinkedNode == null){
            return -1;
        }else {
            moveToTail(dLinkedNode);
            return dLinkedNode.value;
        }
    }
    public void put(int key ,int value){
        DLinkedNode node = cache.get(key);
        if(node == null){
            node = new DLinkedNode(key,value);
            if(size==capacity){
                //删除头节点
                removeHead();
                //添加尾节点
                addToTail(node);
            }else{
                //直接添加尾节点
                addToTail(node);
                size++;
            }
            cache.put(key,node);
        }else{
            node.value = value;
            moveToTail(node);
        }
    }

    void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void moveToTail(DLinkedNode dLinkedNode){
        //先删除当前节点
        removeNode(dLinkedNode);
        //插入尾部
        addToTail(dLinkedNode);
    }
    void addToTail(DLinkedNode dLinkedNode){
        tail.prev.next = dLinkedNode;
        dLinkedNode.prev = tail.prev;
        dLinkedNode.next = tail;
        tail.prev = dLinkedNode;
    }

    void removeHead(){
        cache.remove(head.next.key);
        removeNode(head.next);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2,1);
        System.out.println(lruCache.get(2));
        lruCache.put(3,2);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
    }
}
