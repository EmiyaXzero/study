package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @description :面试题57. 和为s的两个数字
 * @Date: 2020/5/2 13:10
 **/
public class TwoSum57 {
    /**
     * 有序双指针查找target
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int i = 0; int j = nums.length-1;
        while (i<j){
            if(nums[i]+nums[j] == target){
                return new int[]{nums[i],nums[j]};
            }
            if(nums[j]>target-nums[i]){
                j--;
            }else{
                i++;
            }
        }
        return new int[]{};
    }
}
