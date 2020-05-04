package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shanghang
 * @Project:study
 * @description:1013. 将数组分成和相等的三个部分
 * @Date: 2020/5/4 18:54
 **/
public class CanThreePartsEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int allSum = 0;
        for (int i : A) {
            allSum+=i;
        }
        if(allSum%3!=0){
            return false;
        }else {
            int target = allSum/3;
            int sum = 0;
            List<Integer> allIdx = new ArrayList<>();
            for (int i = 0;i<A.length;i++){
                sum+=A[i];
                if(sum == target && A[i] != 0){
                    sum = 0;
                    allIdx.add(i);
                }
            }
            if(allIdx.size()<3){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanThreePartsEqualSum canThreePartsEqualSum = new CanThreePartsEqualSum();
        canThreePartsEqualSum.canThreePartsEqualSum(new int[]{10,-10,10,-10,10,-10,10,-10});
    }
}
