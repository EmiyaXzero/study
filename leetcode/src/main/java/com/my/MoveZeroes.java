package com.my;

/**
 * 移动零
 * @author shang
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return;
        }
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                j = i + 1;
                for (; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
            i++;
        }
    }

    /**
     * j维持的是非0数的长度，i遍历整个数组
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return;
        }
        int j = 0;
        for (int i = 0;i<nums.length;i++){
            if(nums[i] !=0){
                if(i!=j){
                   nums[j] = nums[i];
                   nums[i] = 0;
                }
                j++;
            }
        }
    }
}
