package com.my;

import java.util.Arrays;

/**
 * @Author: shanghang
 * @Project:study
 * @description:174. 地下城游戏
 * @Date: 2020/7/12 22:41
 **/
public class CalculateMinimumHP {
    public int calculateMinimumHP(int[][] dungeon) {
        int lenX = dungeon.length;
        int lenY = dungeon[0].length;
        int[][] dp = new int[lenX+1][lenY+1];
        for (int i = 0;i<lenX+1;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        //最小也有1滴血
        dp[lenX-1][lenY] = dp[lenX][lenY-1] = 1;
        for (int i = lenX-1;i>=0;i--){
            for (int j = lenY-1 ;j>=0;j--){
                //右边和下边的最小值
                int min = Math.min(dp[i+1][j],dp[i][j+1]);
                dp[i][j] = Math.max(min-dungeon[i][j],1);
            }
        }
        return dp[0][0];
    }
}
