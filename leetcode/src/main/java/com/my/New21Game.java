package com.my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: shanghang
 * @Project:study
 * @description:837. 新21点
 * @Date: 2020/6/3 23:25
 **/
public class New21Game {
    /**
     *
     * @param N
     * @param K
     * @param W
     * @return
     */
    public double new21Game(int N, int K, int W) {
        if(K == 0){
            return 1;
        }
        double[] dp = new double[K+W];
        //分数在k到 min(N,K+W-1)的时候直接获胜,K+W-1是最后一次抽到的分数为W且前一次是K-1因为只有前一次是K-1才不会退出游戏
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        //dp[x]={dp[x+1]+dp[x+2]+⋯+dp[x+W]}/W;
        for (int i = K-1;i>=0;i--){
            for (int j = i+1;j<=W;j++){
                dp[i]+=dp[i+j]/W;
            }
        }
        return dp[0];
    }

    public double new21GameNewDp(int N, int K, int W) {
        if(K == 0){
            return 1;
        }
        double[] dp = new double[K+W];
        double s = 0;
        //分数在k到 min(N,K+W-1)的时候直接获胜,K+W-1是最后一次抽到的分数为W且前一次是K-1因为只有前一次是K-1才不会退出游戏
        for (int i = K; i < K + W; i++) {
            dp[i] = (i <= N ? 1.0 : 0.0);
            s += dp[i];
        }
        for (int i = K-1;i>=0;i--){
            dp[i] = s/W;
            s = s-dp[i+W]+dp[i];
        }
        /**
         * 或者这样
         *  dp[K-1] = s/W;
         * for (int i = K-2;i>=0;i--){
         *             s = s-dp[i+1+W]+dp[i+1];
         *             dp[i] = s/W;
         *         }
         */

        return dp[0];
    }

    public static void main(String[] args) {
        New21Game new21Game = new New21Game();
        new21Game.new21GameNewDp(21,17,10);
    }

}
