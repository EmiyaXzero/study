package com.my;

import java.util.Arrays;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/11 11:25
 **/
public class SuperEggDrop {
    /**
     *
     * @param k
     * @param n
     * @return
     */
    public int superEggDrop(int k, int n) {
        //横坐标楼层，纵坐标蛋的个数
        int[][] dp = new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            //i层楼一个蛋的情况
            dp[i][1] = i;
        }
        for(int i=0;i<=k;i++){
            //一层楼i个蛋的情况
            dp[1][i] = 1;
        }
        for (int i =2 ;i<=n;i++){
            for (int j = 2 ;j<=k;j++){
                //枚举从x层蛋碎的情况
               for (int x = 1;x<=i;x++){
                   //在x层蛋碎了就是找j-1个蛋在x-1层的最小值，没碎就是i-x j个蛋的最小值，最后+上本次的操作
                   int tempMaxX = Math.max(dp[x-1][j-1],dp[i-x][j])+1;
                   if(dp[i][j] == 0 ){
                       //第一次给dp[i][j]赋值
                       //在x层蛋碎了就是找j-1个蛋在x层的最小值，没碎就是i-x j个蛋的最小值，最后+上本次的操作
                       dp[i][j] = tempMaxX;
                   }else {
                       dp[i][j] = Math.min(dp[i][j],tempMaxX);
                   }

               }
            }
        }
        return dp[n][k];
    }

    public int superEggDrop2(int k, int n) {
        //横坐标楼层，纵坐标蛋的个数
        int[][] dp = new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            //i层楼一个蛋的情况
            dp[i][1] = i;
        }
        for(int i=0;i<=k;i++){
            //一层楼i个蛋的情况
            dp[1][i] = 1;
        }
        for (int i =2 ;i<=n;i++){
            //二分法找到x 使dp[x-1][j-1]<=dp[i-x][j],因为dp[x-1][j-1]根据x增大而增大，dp[i-x][j] x随x增大而减小
            for (int j = 2 ;j<=k;j++){
                int left = 1;
                int right = i;
                while (left <right){
                    int mid = left + (right - left + 1) / 2;
                    int leftCount = dp[mid-1][j-1];
                    int rightCount = dp[i-mid][j];
                    if(leftCount>rightCount){
                        right = mid-1;
                    }else {
                        left = mid;
                    }
                }
                dp[i][j] = Math.max(dp[left-1][j-1],dp[i-left][j])+1;
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        SuperEggDrop superEggDrop = new SuperEggDrop();
        superEggDrop.superEggDrop(2,6);
    }
}
