package com.my;

/**
 * @author shanghang
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int all = 1;
        for (int num : nums){
            all*=num;
        }
        int[] dp = new int[nums.length];
        for (int i = 0 ;i<nums.length;i++){
            dp[i] = all/nums[i];
        }
        return dp;
    }
}
