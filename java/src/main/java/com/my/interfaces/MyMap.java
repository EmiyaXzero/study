package com.my.interfaces;

/**
 * 定义一个map接口
 * @author shanghang
 */
public interface MyMap<K,V> {
    /**
     * set方法
     * @param K
     * @param V
     * @return
     */
    public V put(K K,V V);

    /**
     * get方法
     * @param K
     * @return
     */
    public V get(K K);

    /**
     * 内部接口
     * @param <K>
     * @param <V>
     */
    interface Entry<K,V>{
        /**
         * 遍历map获取key
         * @return
         */
            public K getKey();

        /**
         * 遍历map获取value
         * @return
         */
        public V getValue();
        }
}
