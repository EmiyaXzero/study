package com.my;

import java.util.Arrays;

/**
 * @Author: shanghang
 * @Project:study
 * @description:64. 最小路径和
 * @Date: 2020/7/23 22:31
 **/
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
        for (int i = 0 ;i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[n][m-1] = 0;
        dp[n-1][m] = 0;
        for (int i = n ;i>=1;i--){
            for (int j = m;j>=1;j--){
                dp[i-1][j-1] = grid[i-1][j-1]+Math.min(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[0][0];
    }
}
