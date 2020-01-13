package com.my;

import java.util.Arrays;

/**
 * @author shang
 * @title: FindDuplicate
 * @projectName study
 * @description: TODO
 * @date 2020/1/13-15:51
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i+1] == nums[i]){
                return nums[i];
            }
        }
        return 0;
    }
}
