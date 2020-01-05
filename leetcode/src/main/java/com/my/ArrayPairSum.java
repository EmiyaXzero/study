package com.my;

import java.util.Arrays;

/**
 * 数组拆分 I
 * @author shanghang
 */
public class ArrayPairSum {
    /**
     * 将数组排序，相邻两个数值取最小的就能够让min(ai,bi)总和最大
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        int result = 0;
        //将数组排序，使得从1 到 n 的 min(ai, bi) 总和最大
        Arrays.sort(nums);
        for (int i =0;i<nums.length;i=i+2){
            result+=nums[i];
        }
        return result;
    }
}
