package com.my;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/5 11:00
 **/
public class LFUCache {
    private Node[] entry;

    private int size = 0;

    /**
     * 记录key对应的数组下标
     */
    private HashMap<Integer,Integer> index = new HashMap<Integer,Integer>();

    /**
     * key是次数，value是同样调用的entry的key
     */
    public  List<List<Node>> allCount = new ArrayList<List<Node>>();

    public LFUCache(int capacity) {
        entry = new Node[capacity];
    }

    public int get(int key) {
        if(!index.containsKey(key)){
            return -1;
        }else {
            Node tempNode = entry[index.get(key)];
            int tempCount = ++tempNode.count;
            //将调用更新到allCount
            List<Node> tempList;
            if (tempCount != 0) {
                //先remove allCount上一次调用的arryalist
                int lastSize = allCount.get(tempCount - 1).size();
                allCount.get(tempCount - 1).remove(tempNode);
            }
            if(tempCount < allCount.size()){
                tempList = allCount.get(tempCount);
            }else {
                tempList = new ArrayList<>();
                allCount.add(tempCount,tempList);
            }
            tempList.add(tempNode);
            return tempNode.value;
        }
    }

    public void put(int key, int value) {
        List<Node> tempList;
        if(index.containsKey(key)){
            //替换掉的value也算加一
            Node tempNode = entry[index.get(key)];
            tempNode.value =value;
            int tempCount = ++tempNode.count;
            //将调用更新到allCount
            if (tempCount != 0) {
                //先remove allCount上一次调用的arryalist
                int lastSize = allCount.get(tempCount - 1).size();
                allCount.get(tempCount - 1).remove(tempNode);
            }
            if(tempCount < allCount.size()){
                tempList = allCount.get(tempCount);
            }else {
                tempList = new ArrayList<>();
                allCount.add(tempCount,tempList);
            }
            tempList.add(tempNode);
            return;
        }
        if(size < entry.length){
            if(!index.containsKey(key)){
                entry[size] = new Node(key,value);

                if(allCount.size() == 0){
                    tempList = new ArrayList<>();
                    allCount.add(0,tempList);
                }else {
                    tempList = allCount.get(0);
                }
                tempList.add(entry[size]);
                index.put(key,size);
                size++;
            }
        }else {
            //需要找到最小调用
            for (int i = 0 ;i<allCount.size();i++){
                if(allCount.get(i).size()>0){
                    //remove掉这个节点
                    Node tempNode = allCount.get(i).get(0);
                    int oldIndex = index.get(tempNode.key);
                    Node newNode = new Node(key,value);
                    entry[oldIndex] = newNode;
                    index.put(key,oldIndex);
                    if(allCount.size() == 0){
                        tempList = new ArrayList<>();
                        allCount.add(0,tempList);
                    }else {
                        tempList = allCount.get(0);
                    }
                    tempList.add(newNode);
                    allCount.get(i).remove(0);
                    index.remove(tempNode.key);
                    break;
                }
            }
        }

    }

    class Node{
        int key;
        int value;
        int count =0;
        Node(int key ,int value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(3,1);
        lfuCache.put(2,1);
        lfuCache.put(2,2);
        lfuCache.put(4,4);
        lfuCache.get(2);

    }
}
