package com.my;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: shanghang
 * @Project:study
 * @description:41. 缺失的第一个正数
 * @Date: 2020/6/27 10:11
 **/
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> has = new HashSet<>();
        int min = 1;
        for (int i = 0;i<nums.length;i++){
            if(nums[i]<1){
                continue;
            }else if(has.contains(nums[i])){
                continue;
            } else if(nums[i] == min){
                has.add(nums[i]);
                min++;
            }else {
                return min;
            }
        }
        return min;
    }
}
