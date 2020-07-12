package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shanghang
 * @Project:study
 * @description:315. 计算右侧小于当前元素的个数
 * @Date: 2020/7/11 17:55
 **/
public class CountSmaller {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length<=0){
            return result;
        }
        for (int i = 0;i<nums.length-1;i++){
            int temp = 0;
            for (int j = i+1;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    temp++;
                }
            }
            result.add(temp);
        }
        result.add(0);
        return result;
    }

    private int[] index;
    private int[] helper;
    private int[] count;
    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        index = new int[len];
        helper = new int[len];
        count = new int[len];
        //索引赋值
        for (int i = 0 ;i<len;i++){
            index[i] = i;
        }
        //归并排序
        merge(nums,0,nums.length-1);
        for (int temp : count){
            result.add(temp);
        }
        return result;
    }

    private void merge(int[] nums, int left, int right) {
        if(left >= right){
            return;
        }
        int mid = (left+right)/2;
        if(left<mid){
            merge(nums,left,mid);
        }
        if(mid+1<right){
            merge(nums,mid+1,right);
        }
        //归并比较
        int i = left ,j = mid+1;
        int hi = left;
        while (i<=mid && j<=right){
            if(nums[index[i]]<=nums[index[j]]){
                //右侧大的进入helper
                helper[hi++] = index[j++];
            }else {
                //左侧出
                count[index[i]] += right-j+1;
                helper[hi++] = index[i++];
            }
        }
        while(i<=mid){
            //左侧出
            helper[hi++] = index[i++];
        }
        while (j<=right){
            helper[hi++] = index[j++];
        }
        for (int k =left ;k<=right;k++){
            index[k] = helper[k];
        }
    }

    public static void main(String[] args) {
        CountSmaller countSmaller = new CountSmaller();
        countSmaller.countSmaller2(new int[]{5,2,6,1});
    }
}
