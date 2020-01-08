package com.my;

/**
 * @author shanghang
 */
public class Search {
    public int search(int[] nums, int target) {
        if (null == nums || nums.length<=0) {
            return -1;
        }
        int result = -1;
        int key = 0;
        //nums旋转排序数组
        for (int i =0 ;i <nums.length;i++){
            if(target == nums[i]){
                return i;
            }
            if(i+1 < nums.length){
                if(nums[i+1]<nums[i]){
                    if(nums[i+1] == target){
                        return i+1;
                    }
                    //i+1是旋转节点
                    key = i+1;
                    break;
                }
            }
        }
        int mid = (nums.length - key)/2 + key;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid]>target){
            for (int i = key+1;i<mid;i++){
                if(target == nums[i]){
                    return i;
                }
            }
        }else{
            for (int i = mid+1;i<nums.length;i++){
                if(target == nums[i]){
                    return i;
                }
            }
        }
        return result;
    }
    public int search2(int[] nums, int target) {
        int left =0;
        int right = nums.length-1;
        int mid = left+(right-left)/2;
        while (left<=right){
            if (nums[mid] == target){
                return mid;
            }
            if(nums[left]<=nums[mid]){
                //存在旋转，得看数字是不是这个区间
                if(target>=nums[left] && target<nums[mid]){
                    //在mid左边
                    right = mid-1;
                }else {
                    //在mid右边
                    left = mid+1;
                }
            }else {
                if(target>nums[mid] && target<=nums[right]){
                    //mid右边
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
            mid = right - (right+left)/2;
        }
        return -1;
    }

    /**
     * 二分查找
     */
    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid]<target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }
}
