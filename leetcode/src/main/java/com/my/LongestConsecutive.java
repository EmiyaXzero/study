package com.my;


import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @description:128. 最长连续序列
 * @Date: 2020/6/6 12:43
 **/
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if(nums.length<=0){
            return 0;
        }
        Set<Integer> sets = new HashSet<>();
        for (int num : nums) {
            sets.add(num);
        }
        int result = 0;
        for (int num:sets){
            if (!sets.contains(num-1)){
                int currentNum = num;
                int len = 1;
                while (sets.contains(currentNum+1)){
                    currentNum++;
                    len++;
                }
                result = Math.max(len,result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        longestConsecutive.longestConsecutive(new int[]{100,4,200,1,3,2});
    }
}
