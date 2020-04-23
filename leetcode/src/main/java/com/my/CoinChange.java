package com.my;

import java.util.Arrays;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/23 21:51
 **/
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for (int i = 0;i<dp.length;i++){
            for (int j = 0 ; j<dp[0].length;j++){
                dp[i][j] = amount+1;
            }
        }
        for (int i = 1 ;i<=coins.length;i++){
            dp[i][0] = 1;
        }
        for (int i = 1 ;i<coins.length;i++){
            for (int j = coins[i-1];j<=amount;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-coins[i-1]]+1);
            }
        }


        if(dp[coins.length][amount] == amount+1){
            return -1;
        }else {
            return dp[coins.length][amount] ;
        }
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        coinChange.coinChange(new int[]{1,2,5},11);
    }
}
