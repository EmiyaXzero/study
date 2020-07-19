package com.my;

import java.util.Arrays;

/**
 * @Author: shanghang
 * @Project:study
 * @description:312. 戳气球
 * @Date: 2020/7/19 11:37
 **/
public class MaxCoins {
    int[] val ;
    int[][] rec;
    public int maxCoins(int[] nums) {
        val = new int[nums.length+2];
        val[0] = val[val.length-1] = 1;
        for (int i = 1;i<=nums.length;i++){
            val[i] = nums[i-1];
        }
        rec = new int[val.length][val.length];
        for (int i = 0;i<rec.length;i++){
            Arrays.fill(rec[i],-1);
        }
        return solve(0,val.length-1);
    }

    /**
     * 通过遍历 left i right 和中间的最大值获取
     * @param left
     * @param right
     * @return
     */
    public int solve(int left ,int right){
        if(left>=right-1){
            return 0;
        }
        if(rec[left][right] != -1){
            return rec[left][right];
        }
        for (int i = left+1;i<right;i++ ){
            int sum = val[left]*val[right]*val[i];
            int add = solve(left,i)+solve(i,right);
            rec[left][right] = Math.max(sum+add,rec[left][right]);
        }
        return rec[left][right];
    }

    public int maxCoins2(int[] nums){
        val = new int[nums.length+2];
        val[0] = val[val.length-1] = 1;
        for (int i = 1;i<=nums.length;i++){
            val[i] = nums[i-1];
        }
        rec = new int[val.length][val.length];
        for (int i = nums.length-1;i>=0;i--){
            for (int j = i+2;j<nums.length+2;j++){
                for (int k = i+1;k<j;k++){
                    int sum = val[i]*val[k]*val[j];
                    sum+=rec[i][k]+rec[k][j];
                    rec[i][j] = Math.max(sum, rec[i][j]);
                }
            }
        }
        return rec[0][nums.length+1];
    }
}
