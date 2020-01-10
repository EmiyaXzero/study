package com.my;

/**
 * 搜索插入位置
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/1/10 21:43
 **/
public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(len<=0){
            return 0;
        }
        if (len == 1 ){
            if(nums[0] == target){
                return 0;
            }else {
                return  nums[0]>target?0:1;
            }
        }
        int left = 0 ,right = len-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]<target){
                if(mid+1 == len || nums[mid+1]>target) {
                    return mid + 1;
                }
            }
            if(nums[mid]>target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1}, 1));
    }
}
