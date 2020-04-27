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
        //二分法
        int left = 0 ,right = nums.length-1;
        //需要判断是否存在旋转
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left]<=nums[mid]){
                //左半边有序
                //  if(nums[mid]< target && nums[right]>=target){
                //      left = mid+1;
                //  }else{
                //      right = mid-1;
                //  }
                if(nums[mid]>target && target>= nums[left]){
                    //目标值在有序的半边，将搜索范围置为左边
                    //如果nums[mid]>target必须也要满足target是比nums[left]小才能right = mid-1
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                //右半边有序
                //存在旋转
                if(nums[mid]<target && nums[right]>=target){
                    //目标值在有序的半边，将搜索范围置为右边
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
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
