package com.my;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * 删除排序数组中的重复项
 * @author shang
 */
public class RemoveDuplicates {
    /**
     * 数组是有序的
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int result = 0;
        if(null == nums || nums.length<=0){
            return result;
        }
        if(nums.length == 1){
            return 1;
        }else if(nums.length == 2 && nums[0] == nums[1] || nums[0] == nums[nums.length-1]){
            return 1;
        }else if(nums.length == 2){
            return 2;
        }
        List<Integer> num = new ArrayList<>();
        num.add(nums[0]);
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i] != nums[i-1]){
                num.add(nums[i]);
            }
        }
        for (int i = 0; i <num.size() ; i++) {
            nums[i] = num.get(i);
        }
        return num.size();
    }

    /**
     * 双指针,快指针往右遍历，当快指针到不重复的值的时候，将值给慢指针，最后慢指针++
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        int result = 0;
        if(null == nums || nums.length<=0){
            return result;
        }
        if(nums.length == 1){
            return 1;
        }else if(nums.length == 2 && nums[0] == nums[1] || nums[0] == nums[nums.length-1]){
            return 1;
        }else if(nums.length == 2){
            return 2;
        }
        int j=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]){

            }else{
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

        public static void main(String[] args) {
        removeDuplicates(new int[]{1,2,2,2});
    }
}
