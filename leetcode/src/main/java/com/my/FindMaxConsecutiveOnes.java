package com.my;

/**
 * 最大连续1的个数
 * @author shang
 */
public class FindMaxConsecutiveOnes {
    /**
     * 双指针窗口移动
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int left = 0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i] !=1){
                left = i+1;
            }else {
                max = (i-left+1 >= max) ? i-left+1 : max;
            }
        }
        return max;
    }
}
