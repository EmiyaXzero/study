package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @description:238. 除自身以外数组的乘积
 * @Date: 2020/6/4 23:38
 **/
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[nums.length];
        left[0] = 1;
        for (int i = 1;i<nums.length;i++){
            left[i] = left[i-1]*nums[i-1];
        }
        right[nums.length-1] = 1;
        for (int i = nums.length-2;i>=0;i--){
            right[i] = right[i+1]*nums[i+1];
        }
        for (int i = 0 ;i<nums.length;i++){
            result[i] = left[i]*right[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        productExceptSelf.productExceptSelf(new int[]{1,2,3,4});
    }
}
