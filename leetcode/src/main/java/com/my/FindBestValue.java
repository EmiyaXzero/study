package com.my;

import java.util.Arrays;

/**
 * @Author: shanghang
 * @Project:study
 * @description:1300. 转变数组后最接近目标值的数组和
 * @Date: 2020/6/14 21:08
 **/
public class FindBestValue {
    public int findBestValue(int[] arr, int target) {
        int len = arr.length;
        int avg = Math.round((float) target/len);
        Arrays.sort(arr);
        if(avg>arr[len-1]){
            return arr[len-1];
        }
        // 记录前一轮的差值
        int pre = Integer.MAX_VALUE;
        // 从平均值开始遍历
        for (int i = avg; ; ++i) {
            // 记录每轮的总和
            int sum = 0;
            for (int value : arr) {
                sum += Math.min(value, i);
            }
            // 比较差值，看前一个点是否是最小值
            if (Math.abs(sum - target) >= pre) {
                return i - 1;
            }
            // 更新差值记录
            pre = Math.abs(sum - target);
        }
    }
    public int findBestValue2(int[] arr, int target) {
        int len = arr.length;
        int avg = Math.round((float) target/len);
        Arrays.sort(arr);
        if(avg>arr[len-1]){
            return arr[len-1];
        }
        int[] prefix = new int[len+1];
        for (int i = 1; i <= len; ++i) {
            //前缀和
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        int r = arr[len-1];
        int ans = 0,diff = target;
        for (int i = 0 ;i<=r ;i++){
            //二分查找
            int idx = Arrays.binarySearch(arr,i);
            if (idx<0){
                idx = -idx-1;
            }
            int cur = prefix[idx] + (len - idx) * i;
            if (Math.abs(cur - target) < diff) {
                ans = i;
                diff = Math.abs(cur - target);
            }
        }
        return ans;
    }
}
