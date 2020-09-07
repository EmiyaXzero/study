package com.my;

import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @description:347. 前 K 个高频元素
 * @Date: 2020/9/7 22:00
 **/
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<int[]> values = new ArrayList<>();
        for (int i : map.keySet()) {
            values.add(new int[]{map.get(i),i});
        }
        values.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        int[] result = new int[k];
        for (int i = 0 ;i<k;i++){
            result[i] = values.get(i)[1];
        }
        return result;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i : map.keySet()) {
            queue.add(new int[]{map.get(i),i});
        }
        int[] result = new int[k];
        for (int i = 0 ;i<k;i++){
            result[i] = queue.poll()[1];
        }
        return result;
    }
}
