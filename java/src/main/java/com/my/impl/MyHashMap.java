package com.my.impl;

import com.my.interfaces.MyMap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shanghang
 */
public class MyHashMap<K,V> implements MyMap<K,V> {
    /**
     * 默认长度16
     */
    public static final int DEFAULT_INITIAL_CAPACITY = 1<<4;

    /**
     * 默认阈值
     */
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int defaultInitSize ;

    private float defaultLoadFactor;
    /**
     * Map当中的entry的数量
     */
    private int entryUseSize;

    /**
     * 数组
     */
    private Entry<K,V>[] table = null;

    /**
     * 构造函数，"门面模式"，对外暴露两个门面
     */
    public MyHashMap(){
        this(DEFAULT_INITIAL_CAPACITY,DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int defaultInitSize ,float defaultLoadFactor){
        if(defaultInitSize<0){
            throw new IllegalArgumentException("异常初始化长度:"+defaultInitSize);
        }
        if(defaultLoadFactor<=0 || Float.isNaN(defaultLoadFactor)){
            throw new IllegalArgumentException("异常动态扩容长度:"+defaultInitSize);
        }
        this.defaultInitSize = defaultInitSize;
        this.defaultLoadFactor = defaultLoadFactor;
        table = new Entry[defaultInitSize];
    }

    /**
     * 链表
     * @param <K>
     * @param <V>
     */
    class Entry<K,V> implements MyMap.Entry<K,V>{
        private K key;
        private V value;
        private Entry<K,V> next;
        public Entry(){

        }

        public Entry(K key,V value,Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }

    @Override
    public V put(K K, V V) {
        V oldValue = null;
        //是否需要扩容
        //扩容完毕 肯定需要重新散列
        if(entryUseSize >= defaultInitSize*defaultLoadFactor){
            resize(defaultInitSize*2);
        }
        int index = hash(K) & (defaultInitSize - 1);
        if(table[index] == null){
            //数组为空直接塞进去
            table[index] = new Entry<K,V>(K,V,null);
        }else {
            //遍历链表，看看有没有相同的key
            Entry<K,V> entry = table[index];
            Entry<K,V> e = entry;
            while (e != null){
                if(K == e.getKey()  || K.equals(e.getKey())){
                    oldValue = e.value;
                    e.value = V;
                    return oldValue;
                }
                e = e.next;
            }
            //将新的值放在链表头
            table[index] = new Entry<>(K,V,entry);
        }
        ++entryUseSize;
        return oldValue;
    }

    @Override
    public V get(K K) {
        V oldValue = null;
        int index = hash(K) & (defaultInitSize - 1);
        if(table[index] != null){
            //遍历链表，看看有没有相同的key
            Entry<K,V> entry = table[index];
           do{
                if (entry.getKey() == K || entry.getKey().equals(K)){
                    return entry.getValue();
                }
                entry = entry.next;
            } while (entry != null);
        }else{
            return null;
        }
        return oldValue;
    }


    private int hash(K k){
        int hashCode = k.hashCode();
        hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
        return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4);
    }

    private void resize(int i ){
        //创建一个新数组
        Entry<K,V>[] newTable = new Entry[i];
        defaultInitSize = i;
        entryUseSize = 0;
        rehash(newTable);
    }

    private void rehash(Entry<K,V>[] newTable) {
        //得到原来的老的entry集合
        List<Entry<K,V>> entries = new ArrayList<Entry<K,V>>();
        for (Entry<K,V> entry : table){
            //遍历原来的table
            if(entry != null){
                //然后再遍历列表
                do {
                    entries.add(entry);
                    entry = entry.next;
                }while (entry != null);
            }
        }
        //覆盖旧的引用
        if(newTable.length > 0){
            table = newTable;
        }
        //重新put到新table
        for(Entry<K,V> entry : entries){
            put(entry.getKey(),entry.getValue());
        }
    }
}
