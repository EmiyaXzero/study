package com.my;

/**
 * @author shang
 * @title: MaxProduct
 * @projectName study
 * @description: 152. 乘积最大子数组
 * @date 2020/5/18-13:44
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        if(nums.length<=0){
            return 0;
        }
        // dp[i][0]：以 nums[i] 结尾的连续子数组的最大值
        // dp[i][1]：以 nums[i] 结尾的连续子数组的最小值
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int max = nums[0];
        for (int i = 1 ;i<nums.length;i++){
           if(nums[i]>=0){
               dp[i][0] = Math.max(nums[i],nums[i]*dp[i-1][0]);
               dp[i][1] = Math.min(nums[i],nums[i]*dp[i-1][1]);
           }else {
               dp[i][0] = Math.max(nums[i],nums[i]*dp[i-1][1]);
               dp[i][1] = Math.min(nums[i],nums[i]*dp[i-1][0]);
           }
           max = Math.max(dp[i][0],max);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        maxProduct.maxProduct(new int[]{2,3,-2,4});
    }
}
