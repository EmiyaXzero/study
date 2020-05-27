package com.my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5399. 数位成本和为目标值的最大数字
 * @Date: 2020/5/16 23:10
 **/
public class LargestNumber {
    static class  Pojo{
        int cost;
        int idx;

        Pojo(int cost,int idx){
            this.cost = cost;
            this.idx = idx;
        }
    }
    List<String> results = new ArrayList<>();
    public String largestNumber(int[] cost, int target) {
        Pojo[] pojos = new Pojo[cost.length];
        for (int i = 0 ;i<cost.length;i++){
            pojos[i] = new Pojo(cost[i],i+1);
        }
        Arrays.sort(pojos, new Comparator<Pojo>() {
            @Override
            public int compare(Pojo o1, Pojo o2) {
                return o1.cost-o2.cost;
            }
        });
        doSum(pojos,target,0,"");
        if(results.size() == 0){
            return "0";
        }else {
            String maxString = results.get(0);
            for (int i = 1;i<results.size();i++){
                if(results.get(i).length()>maxString.length()){
                    maxString = results.get(i);
                }else if(results.get(i).length() == maxString.length()){
                    for (int j = 0;j<maxString.length();j++){
                        if (results.get(i).charAt(j)>maxString.charAt(j)){
                            maxString = results.get(i);
                            break;
                        }else if(results.get(i).charAt(j)<maxString.charAt(j)){
                            break;
                        }
                    }
                }
            }
            return maxString;
        }
    }

    private void doSum(Pojo[] pojos, int target, int sum ,String s) {
        for (int i = 0 ;i<pojos.length;i++){
            int maxIdx = pojos[i].idx;
            while (i+1<pojos.length && pojos[i+1].cost == pojos[i].cost){
                maxIdx = Math.max(pojos[i+1].idx,maxIdx);
                i++;
            }
            int tempSum = sum+pojos[i].cost;
            if(tempSum<target){
                doSum(pojos,target,tempSum,s+maxIdx);
            }
            if(tempSum == target){
                results.add(s+maxIdx);
            }
            if(tempSum>target){
                return;
            }
        }
    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        largestNumber.largestNumber(new int[]{70,84,55,63,74,44,27,76,34},659);
    }
}
