package com.my;

/**
 * @author shang
 */
public class PivotIndex {
    /**
     * 暴力法遍历
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {
        if(nums == null || nums.length<2){
            return -1;
        }
        for (int i = 0;i<nums.length;i++){
            int left = 0;
            int right = 0;
            for (int j = 0; j <i ; j++) {
                left+=nums[j];
            }
            for (int j = i+1; j <nums.length ; j++) {
                right+=nums[j];
            }
            if (left == right){
                return i;
            }
        }
        return -1;
    }

    public static int pivotIndex2(int[] nums) {
        if(nums == null || nums.length<2){
            return -1;
        }
        int left = 0;
        int right = 0;
        for (int i= 1 ; i <nums.length;i++){
            right += nums[i];
        }
        if(left == right){
            return 0;
        }
        for (int i = 1;i<nums.length;i++){
            left+=nums[i-1];
            right-=nums[i];
            if (left == right){
                return i;
            }
        }
        return -1;
    }

    public static int sum(int[] nums, int left, int right){
        int sum = 0;
        for (int i = left; i < right; i++) {
            sum+=nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex2(new int[]{ 1, 1, 0, -1, -1,0}));
    }
}
