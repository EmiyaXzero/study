package com.my;

import java.util.Arrays;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/25 15:07
 **/
public class ExpectNumber {
    public int expectNumber(int[] scores) {
        //让scores从小到大排序
        Arrays.sort(scores);
        int left = 0 ,right = 1;
        int count = 0;
        while (left<scores.length && right<scores.length){
            if(scores[right] != scores[left]){
                count++;
                left = right;
            }
            right++;
        }
        if(left !=right){
            count++;
        }
        return count;
    }
}
