package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @description:718. 最长重复子数组
 * @Date: 2020/7/1 22:39
 **/
public class FindLength {
    public int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[A.length+1][B.length+1];
        for (int i = 1;i<=A.length;i++){
            for (int j = 1;j<=B.length;j++){
                if(A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        if(max == Integer.MIN_VALUE){
            max = 0;
        }
        return max;
    }
}
