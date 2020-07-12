package com.my;

import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @description:面试题 16.11. 跳水板
 * @Date: 2020/7/8 20:51
 **/
public class DivingBoard {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k<=0){
            return new int[0];
        }
        if(shorter == longer){
            return new int[]{k*longer};
        }
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 1;i<=k;i++){
            integerSet.add(shorter*i+longer*(k-i));
        }
        int[] result = new int[integerSet.size()];
        int z = 0;
        for (Integer i: integerSet) {
            result[z++] = i;
        }
        Arrays.sort(result);
        return result;
    }

}
