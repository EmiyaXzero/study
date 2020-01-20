package com.my;

/**
 * @author shang
 * @title: MyHashMap
 * @projectName study
 * @description: 设计哈希映射
 * @date 2020/1/20-21:05
 */
public class MyHashMap {
    Integer[] values;

    public MyHashMap() {
        this.values = new Integer[1000000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int y = key%1000000;
        values[y] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int y = key%1000000;
        if(values[y]!=null ){
            return values[y];
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int y = key%1000000;
        if(values[y]!=null ){
            values[y] = null;
        }
    }
}
