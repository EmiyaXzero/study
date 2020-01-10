package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/1/10 15:12
 *
 **/
public class FindPeakElement {
    /**
     * nums[i] ≠ nums[i+1]
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        if(nums == null || nums.length<2){
            return 0;
        }
        int left = 0 ,right = nums.length-1;
        while(left<=right){
            if(left == 0){
                if(nums[left] >nums[left+1]){
                    return left;
                }
            }else if(nums[left]>nums[left-1] && nums[left] >nums[left+1]){
                return left;
            }
            if(right == nums.length-1){
                if(nums[right]>nums[right-1]){
                    return right;
                }
            }else if(nums[right]>nums[right-1] && nums[right] >nums[right+1]){
                return right;
            }

            left++;
            right--;
        }

        return 0;
    }

    public static void main(String[] args) {
        findPeakElement(new int[]{1,2,3});
    }

    /**
     * O(logN)解法，根据峰的特性，如果mid<mid+1说明在往右长
     * @param nums
     * @return
     */
    public static int findPeakElement2(int[] nums) {
        int left = 0,right = nums.length-1;
        while (left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]<nums[mid+1]){
                //表示上升
                left=mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
