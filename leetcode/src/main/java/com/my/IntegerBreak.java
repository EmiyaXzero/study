package com.my;

import java.util.Map;

/**
 * @Author: shanghang
 * @Project:study
 * @description:343. 整数拆分
 * @Date: 2020/7/30 22:39
 **/
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for (int i =2 ;i<=n;i++){
            int curMax = 0;
            for (int j = 1;j<i;j++){
                curMax = Math.max(curMax,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
