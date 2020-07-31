package com.my;

/**
 * @author shanghang
 * @title: FindMagicIndex
 * @projectName study
 * @description: 面试题 08.03. 魔术索引
 * @date 2020/7/31-14:01
 */
public class FindMagicIndex {
    public int findMagicIndex(int[] nums) {
       return doSort(nums,0,nums.length-1);
    }
    public int doSort(int[] nums ,int left ,int right){
        if(left>right){
            return -1;
        }
        int mid = left + (right-left)/2;
        int answer = doSort(nums,left,mid-1);
        if(answer != -1){
            return answer;
        }else if(nums[mid] == mid){
            return mid;
        }
        return doSort(nums,mid+1,right);
    }
}
