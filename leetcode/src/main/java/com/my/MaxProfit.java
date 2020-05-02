package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @description:股票时间打卡题
 * @Date: 2020/5/2 14:49
 **/
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int length = prices.length;
        int dp[] = new int[length];
        int result = 0;
        for (int i = prices.length - 2;i>=0;i--){
            int cha = prices[i+1]-prices[i];
            dp[i] = dp[i+1]+cha>=cha?dp[i+1]+cha:cha;
            result = dp[i]>=result?dp[i]:result;
        }

        return result;
    }

    /**
     * 1ms解法，用minPrice保存最小的哪天，然后后续求差值
     * @param prices
     * @return
     */
    public int maxProfitFor1ms(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
