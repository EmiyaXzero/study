package com.my;

/**
 * @author shang
 * @title: ReversePairs
 * @projectName study
 * @description: 数组中的逆序对
 * @date 2020/4/24-13:24
 */
public class ReversePairs {
    int sum = 0;
    public int reversePairs(int[] nums) {
        if(nums.length<=0){
            return 0;
        }
        merge(nums,0,nums.length-1);
        return sum;
    }

    /**
     * 归并排序
     */
    public void merge(int[] nums ,int begin ,int end){
        if(begin == end){
            //只有一个值有序
            return;
        }

        int mid = (begin+end)/2;
        //左右拆分直到只有一个
        merge(nums,begin,mid);
        merge(nums,mid+1,end);
        //进行归并操作
        int[] temp = new int[end-begin+1];
        //双指针i=0  j= mid+1 指向分治的两边的队头
        int i = begin ,j = mid+1 ,k = 0;
        while(i<=mid && j <= end){
            //将小的归并,同是k i +1 k++先计算当前再加一，不影响当前赋值
            if(nums[i]<=nums[j]){
                //nums[i]<=nums[j]小于等于j的时候不存在逆序对
                temp[k++] = nums[i++];
            }else {
                //逆序的个数
                sum+= mid-i+1;
                temp[k++] = nums[j++];
            }
        }
        while (i<=mid){
            temp[k++] = nums[i++];
        }
        while (j<=end){
            temp[k++] = nums[j++];
        }
        //将归并的部分合到原数组
        System.arraycopy(temp,0,nums,begin,end-begin+1);
    }
}
