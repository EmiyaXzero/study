package com.my;

/**
 * @author shang
 * @title: MyHashSet
 * @projectName study
 * @description: 设计哈希集合
 * @date 2020/1/19-20:00
 */
public class MyHashSet {
    Integer[] ints;

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.ints = new Integer[1000000];
    }

    public void add(int key) {
        int y = key%1000000;
        ints[y] = key;
    }

    public void remove(int key) {
        int y = key%1000000;
        if(ints[y]!=null  && ints[y] == key){
            ints[y] = null;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int y = key%1000000;
        if(ints[y]!=null && ints[y] == key){
            return true;
        }else {
            return false;
        }
    }
}
