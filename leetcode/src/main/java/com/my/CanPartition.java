package com.my;

import java.util.Arrays;

/**
 * @Author: shanghang
 * @Project:study
 * @description:416. 分割等和子集
 * @Date: 2020/10/11 13:35
 **/
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n<2){
            return false;
        }
        int sum = 0 ,maxNum = 0;
        for (int num : nums){
            sum+=num;
            maxNum = Math.max(num,maxNum);
        }
        if(sum%2 != 0 ){
            return false;
        }
        int target = sum/2;
        if (maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[n][target+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1;i<n;i++){
            int num = nums[i];
            for (int j = 1 ;j<=target;j++){
                if(j>=num){
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][target];
    }

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while(true){
            Thread.sleep(1000);
            System.out.println(++i);
        }
    }
}
