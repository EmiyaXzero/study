package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @description:486. 预测赢家
 * @Date: 2020/9/1 22:45
 **/
public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum+=i;
        }
        int first = f(nums,0,nums.length-1);
        return first>=(sum-first);
    }

    private int f(int[] nums, int i, int j) {
        if (i == j){
            return nums[i];
        }
        if(i+1 == j){
            return Math.max(nums[i],nums[j]);
        }

        //自己取最大的，对手会给你留最小的
        return Math.max(nums[i]+Math.min(f(nums,i+1,j-1),f(nums,i+2,j)),nums[j]+Math.min(f(nums,i+1,j-1),f(nums,i,j-2)));
    }
}
