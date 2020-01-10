package com.my;

/**
 * 寻找旋转排序数组中的最小值
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/1/10 19:28
 **/
public class FindMin {
    public static int findMin(int[] nums) {
        if(null == nums){
            return -1;
        }
        int len = nums.length;
        if( len<= 0){
            return 0;
        }else if(len == 1 || nums[len-1] > nums[0]){
            //长度为一且没有旋转的直接return
            return nums[0];
        }
        if(len == 2){
            return nums[0]>nums[1]?nums[1]:nums[0];
        }
        //找到一个值左边是递增的右边也是递增的
        int left = 0,right = len-1;
        while (left<right){
            int mid = left+(right-left)/2;
            if(mid == len || nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1]){
                return nums[mid];
            }
            if(nums[left] < nums[mid]){
                //left到mid递增
                left = mid;
            }else{
                //递减
                if(nums[mid+1]>nums[mid]){
                    //7123456
                    right = mid;
                }else {
                    //7654321
                    left = mid+1;
                }
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{6,5,4,3,2,1}));
    }
}
