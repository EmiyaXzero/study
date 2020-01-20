package com.my;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author shang
 * @title: ContainsDuplicate
 * @projectName study
 * @description: 存在重复元素
 * @date 2020/1/20-21:25
 */
public class ContainsDuplicate {
    /**
     * hash的contains时候不快，add一般是链表插头
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet values = new HashSet(16);
        for (int num : nums) {
            //contains的时间复杂度高
            if(values.contains(num)){
                return true;
            }else {
                values.add(num);
            }
        }
        return false;
    }
    public boolean containsDuplicate2(int[] nums) {
        //快速排序时间复杂度O(nlogn)
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }
}
