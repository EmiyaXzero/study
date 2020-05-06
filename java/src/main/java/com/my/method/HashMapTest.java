package com.my.method;

import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/7 22:52
 **/
public class HashMapTest {
    public static void main(String[] args) {
        HashMap test1 = new HashMap(7);
        HashMap test2 = new HashMap(1);
        test1.size();
        Hashtable a = new Hashtable();
        test1.put(null,null);
        PriorityQueue priorityQueue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(5);
        priorityQueue.add(4);
        Iterator iterator = priorityQueue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
