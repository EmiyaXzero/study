package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @description:96. 不同的二叉搜索树
 * @Date: 2020/7/15 20:58
 **/
public class NumTrees {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i =2 ;i<=n;i++){
            for (int j = 1; j<=i;j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
