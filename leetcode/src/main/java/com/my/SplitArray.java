package com.my;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author shang
 * @title: SplitArray
 * @projectName study
 * @description:  分割数组的最大值
 * @date 2020/4/27-13:16
 */
public class SplitArray {
    /**
     * 二分法求解
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        if(nums.length == m){
            Arrays.sort(nums);
            return nums[nums.length-1];
        }
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left <right){
            int mid = left +(right-left)/2;
            if(isRight(nums,m,mid)){
                //值过大了
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    private boolean isRight(int[] nums, int m, int mid) {
        int count = 0;
        int sum = 0;
        for (int i = 0 ;i<nums.length;i++){
            if(nums[i]>mid){
                return false;
            }
            sum+=nums[i];
            if(sum>mid){
                //置为第二个数组
                sum = nums[i];
                count++;
                if(count == m){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SplitArray splitArray = new SplitArray();
        splitArray.splitArray(new int[]{2,3,1,1,1,1,1},5);
    }


}
