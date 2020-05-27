package com.my;

import java.util.*;

/**
 * @author shang
 * @title: LRUCache
 * @projectName study
 * @description: 146. LRU缓存机制
 * @date 2020/5/25-13:37
 */
public class LRUCache {
    class Pojo{
        int key;
        int used;

        Pojo(int key,int used){
            this.key = key;
            this.used = used;
        }
    }
    int capacity ;
    int modify = 0;
    Map<Integer,Integer> keys ;
    PriorityQueue<Pojo> deque;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        keys = new HashMap<>(capacity);
        deque = new PriorityQueue<>(capacity, new Comparator<Pojo>() {
            @Override
            public int compare(Pojo o1, Pojo o2) {
                return o1.used-o2.used;
            }
        });
    }

    public int get(int key) {
        if(keys.containsKey(key)){
            Iterator<Pojo> iterator = deque.iterator();
            Pojo pojo = null;
            while (iterator.hasNext()){
                pojo = iterator.next();
                if(pojo.key == key){
                    iterator.remove();
                    break;
                }
            }
            pojo.used=++modify;
            deque.add(pojo);
            return keys.get(key);
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(deque.size()>=capacity && !keys.containsKey(key)){
            Pojo p = deque.poll();
            keys.remove(p.key);
            deque.add(new Pojo(key,++modify));
        }else {
            if(keys.containsKey(key)){
                Iterator<Pojo> iterator = deque.iterator();
                Pojo pojo = null;
                while (iterator.hasNext()){
                    pojo = iterator.next();
                    if(pojo.key == key){
                        iterator.remove();
                        break;
                    }
                }
                pojo.used=++modify;
                deque.add(pojo);
            }else {
                deque.add(new Pojo(key,++modify));
            }
        }
        keys.put(key,value);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.get(2);
        lruCache.put(2,6);
        lruCache.get(1);
        lruCache.put(1,5);
        lruCache.put(1,2);
        lruCache.get(1);
        lruCache.get(2);
    }
}
