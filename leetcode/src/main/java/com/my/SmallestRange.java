package com.my;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shanghang
 * @title: SmallestRange
 * @projectName study
 * @description: 632. 最小区间
 * @date 2020/8/1-16:51
 */
public class SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        int size = nums.size();
        Map<Integer,List<Integer>> indices = new HashMap<>();
        int xMin = Integer.MAX_VALUE, xMax = Integer.MIN_VALUE;
        for (int i = 0;i<size;i++){
            for (int temp : nums.get(i)){
                List<Integer> list = indices.getOrDefault(temp,new ArrayList<Integer>());
                list.add(i);
                indices.put(temp,list);
                xMin = Math.min(xMin,temp);
                xMax = Math.max(xMax,temp);
            }
        }
        int[] freq = new int[size];
        int inside = 0;
        int left = xMin,right = xMin-1;
        int bestLeft = xMin,bestRight = xMax;
        while (right<xMax){
            right++;
            if(indices.containsKey(right)){
                for (int x : indices.get(right)){
                    freq[x]++;
                    if(freq[x] == 1){
                        inside++;
                    }
                }
            }
            while (inside == size){
                if(right-left<bestRight-bestLeft){
                    bestLeft = left;
                    bestRight = right;
                }
                if(indices.containsKey(left)){
                    for (int x : indices.get(left)){
                        freq[x]--;
                        if(freq[x] == 0){
                            inside--;
                        }
                    }
                }
                left++;
            }
        }
        return new int[]{bestLeft,bestRight};
    }
}
