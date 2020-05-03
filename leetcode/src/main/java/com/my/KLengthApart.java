package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5401. 是否所有 1 都至少相隔 k 个元素
 * @Date: 2020/5/3 10:54
 **/
public class KLengthApart {
    public boolean kLengthApart(int[] nums, int k) {
        int p = 0;
        while (p<nums.length && nums[p]==0){
            p++;
        }
        int q = p+1;
        while (p <nums.length && q<nums.length){
            if(nums[q] == 1){
                if(q-p-1<k){
                    return false;
                }
                p = q++;
            }else {
                q++;
            }
        }
        return true;
    }
}
