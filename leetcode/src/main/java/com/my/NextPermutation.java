package com.my;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *  下一个排列
 * @author shanghang
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        int k = 0;
        boolean isCan = false;
        //从右到左找到不是递增的第一位
        for (int i=length -2,j=length-1 ;i>=0 ;i--,j--){
            if(nums[i] <nums[j]){
                isCan = true;
                k = i;
                break;
            }
        }
        if (isCan){
            //因为k右边是递减的,所以当nums[j] <key就j--
            int j = length-1;
            while(j>=0 && nums[j]<=nums[k]){
                j--;
            }
            swap(nums,k,j);
            reverse(nums,k+1);

        }else {
            reverse(nums,0);
        }
    }
    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        nextPermutation(new int[]{1,3,2});
    }

    /**
     * 想太少
     * @param nums
     */
    public void nextPermutation2(int[] nums) {
        int length = nums.length;
        int k = 0;
        boolean isCan = false;
        for (int i=length -2,j=length-1 ;i>=0 ;i--,j--){
            if(nums[i] <nums[j]){
                isCan = true;
                k = i;
                break;
            }
        }
        if (isCan){
            int max = Integer.MAX_VALUE;
            int key = 0;
            for (int j = k+1;j<nums.length;j++){
                //找到一个最小的比K大的值交换，然后将剩下按升序排列
                if(nums[j]>nums[k] && nums[j]<max){
                    key = j;
                    max = nums[j];
                }
            }
            //交换k,key
            int temp = nums[k];
            nums[k] = nums[key];
            nums[key] = temp;
            int[] newNums = new int[nums.length-k-1];
            for (int i=0 ;i<newNums.length;i++){
                newNums[i] = nums[k+i+1];
            }
            Arrays.sort(newNums);
            for (int i = 0 ;i<newNums.length;i++){
                nums[k+i+1] = newNums[i];
            }
        }else {
            Arrays.sort(nums);
        }
    }
}
