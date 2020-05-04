package com.my.method;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.PriorityQueue;

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
        PriorityQueue priorityQueue = new PriorityQueue(Comparator.naturalOrder());
        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(2);
        priorityQueue.remove(2);
        priorityQueue.remove((Integer)2);
    }
}
