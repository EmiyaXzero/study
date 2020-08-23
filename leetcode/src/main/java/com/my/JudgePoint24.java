package com.my;

import java.util.HashSet;

/**
 * @Author: shanghang
 * @Project:study
 * @description:679. 24 点游戏
 * @Date: 2020/8/22 15:37
 **/
public class JudgePoint24 {
    public boolean judgePoint24(int[] nums) {
        HashSet<Double>[] dp = new HashSet[16];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashSet<>();
        }
        dp[1].add((double)nums[0]);
        dp[2].add((double)nums[1]);
        dp[4].add((double)nums[2]);
        dp[8].add((double)nums[3]);
        for (int i = 3;i<16;i++){
            for (int j =(i-1)&i ;j>0;j=--j&i){
                for (double x : dp[j]){
                    for (double y : dp[i^j]){
                        dp[i].add(x-y);
                        dp[i].add(x+y);
                        dp[i].add(x*y);
                        dp[i].add(x/y);
                        dp[i].add(y-x);
                        dp[i].add(y/x);
                    }
                }
            }
        }
        for(double x:dp[15]){
            if(Math.abs(24.0-x)<0.00001){
                return true;
            }
        }
        return false;
    }
}
