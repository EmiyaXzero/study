package com.my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *四数之和
 * @author shanghang
 */
public class FourSum {
    /**
     * 四数之和就是三数之和
     * @param nums
     * @param target
     * @return
     */
    private static List<List<Integer>> lists = new ArrayList<>();

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //LeetCode好像测试用例是一起的
        lists.clear();
        //先给nums排序
        Arrays.sort(nums);
        int count = nums.length;
        if (nums == null || count < 4) {
            return new ArrayList<>();
        }
        for (int i = 0;i <nums.length-3;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            threeSum(i,nums,target-nums[i]);
        }

        return lists;
    }


    public static void threeSum(int key ,int[] nums,int target) {
        int count = nums.length;
        //最小三位数相加大于零直接退出
        if (nums[key+1] + nums[key+2] + nums[key+3] > target) {
            return;
        };
        for (int i = key+1; i < count - 1; i++) {
            //从小到大排列,如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i>key+1 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = count - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    lists.add(Arrays.asList(nums[key],nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else {
                    if (sum < target) {
                        //说明在左边的值太小了需要右移
                        left++;
                    } else {
                        //反之同理
                        right--;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{-1,0,-5,-2,-2,-4,0,1,-2}, -9));
    }
}
