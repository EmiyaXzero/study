package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @description:1014. 最佳观光组合
 * @Date: 2020/6/17 22:06
 **/
public class MaxScoreSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        int max = -1;
        for(int i = 0;i<A.length-1;i++){
            for (int j = i+1;j<A.length;j++){
                max = Math.max(max,(A[j]+A[i])+i-j);
            }
        }
        return max;
    }
    public int maxScoreSightseeingPairForOnce(int[] A) {
        int max = -1 , left = A[0];
        for(int i = 1;i<A.length;i++){
            max = Math.max(max,left+A[i]-i);
            left = Math.max(left,A[i]+i);
        }
        return max;
    }
}
