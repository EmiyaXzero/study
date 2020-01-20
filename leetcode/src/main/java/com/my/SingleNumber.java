package com.my;

import java.util.Arrays;

/**
 * @author shang
 * @title: SingleNumber
 * @projectName study
 * @description: 只出现一次的数字
 * @date 2020/1/20-21:35
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i++) {
            if(i == 0){
                if(nums[i] != nums[i+1]){
                    return nums[i];
                }
            }else if(i== nums.length-1){
                if(nums[i] != nums[i-1]){
                    return nums[i];
                }
            }else {
                if(nums[i] !=nums[i+1] && nums[i] != nums[i-1]){
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
