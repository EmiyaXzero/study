package com.my;

/**
 * @author shang
 * @title: MajorityElement
 * @projectName study
 * @description: 169. 多数元素
 * @date 2020/5/6-17:30
 */
public class MajorityElement {
    /**
     * 投票法,定义一个count如果count等于0的时候将当前值赋值给candidate，如果后面值等于candidate就++，不等就--
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num:nums){
            if(count == 0){
                candidate = num;
            }
            candidate+= candidate==num?1:-1;
        }

        return count;
    }
}
