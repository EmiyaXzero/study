package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/23 20:23
 **/
public class WaysToChange {
    public int waysToChange(int n) {

        double[][] dp = new double[5][n+1];

        for (int i = 1 ;i<=n;i++){
            //由1开头的永远只有1中情况
            dp[1][i] = 1;
            //由5开头每逢5+1
            if(i%5==0){
                dp[2][i] = dp[2][i-1] + 1;
            }else {
                dp[2][i] = dp[2][i-1];
            }
            if(i == 10){
                dp[3][i] = 1;
            }else if(i>10 && i%5 == 0){
                //就等于1,2dp[i-10]的总和
                dp[3][i] = dp[3][i-10]+dp[2][i-10] +dp[1][i-10];
            }else if(i>10){
                dp[3][i] = dp[3][i-1];
            }
            if(i == 25){
                dp[4][i] = 1;
            }else if(i>25 && i%5 == 0){
                dp[4][i] = dp[4][i-25]+dp[3][i-25] + dp[2][i-25] +dp[1][i-25] ;
            }else if(i>25){
                dp[4][i] = dp[4][i-1];
            }
        }
        int result = (int) ((dp[1][n]+dp[2][n]+dp[3][n]+dp[4][n])%1000000007);
        return result;
    }

    /**
     * 背包解法
     * @param n
     * @return
     */
    public int waysToChangeForPackge(int n) {
        int dp[] = new int[n+1];
        int[] coins = new int[]{1,5,10,25};

        for (int coin : coins){
            for (int i = coin ;i<=n;i++){
                dp[i] = (dp[i]+dp[i-coin])%1000000007;
            }
        }
        return dp[n];
    }

    /**
     * 二维背包问题
     * @param n
     * @return
     */
    public int waysToChangeForPackgeFor2(int n){
        int[][] dp = new int[5][n+1];
        for (int i = 1; i <= 4; i++) {
            dp[i][0] = 1;
        }
        int[] coins = new int[]{0,1,5,10,25};
        for (int i = 1 ;i<=4;i++){
            for (int j = 1 ;j<=n;j++){
                if(j - coins[i]<0){
                    //假如到coins[i]时背包已经装满了，那么就只能取coins[i-1]对应的价值
                    dp[i][j] = dp[i-1][j]%1000000007;
                }else {
                    //当前硬币选和当前硬币不选的结果  dp[i-1][j]表示当前硬币不选，由前硬币组成j
                    //dp[i][j-coins[i] 由当前硬币选，前硬币组成j-coins[i]
                    dp[i][j] = (dp[i-1][j] +dp[i-1][j-coins[i]])%1000000007;
                }
            }
        }
        return dp[4][n];
    }

    public static void main(String[] args) {
        WaysToChange waysToChange = new WaysToChange();
        System.out.println(waysToChange.waysToChange(929782));
    }
}
