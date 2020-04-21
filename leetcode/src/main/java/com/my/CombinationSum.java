package com.my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shang
 * @title: CombinationSum
 * @projectName study
 * @description: 组合总和
 * @date 2020/4/21-17:19
 */
public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        //先给数组排序
        Arrays.sort(candidates);
        for (int i = 0 ;i<candidates.length ;i++){

            if(candidates[i]<target){
                List<Integer> list = new ArrayList<>();
                list.add(candidates[i]);
                doComb(candidates,i,list,candidates[i],target);
            }else if(candidates[i]==target){
                //从小到大排序可以退出了
                List<Integer> list = new ArrayList<>();
                list.add(candidates[i]);
                result.add(list);
                return result;
            }else {
                return result;
            }

        }

        return result;
    }

    public void doComb(int[] candidates , int curIdx ,List<Integer> temp ,int sum,int target){
        for (int i = curIdx;i<candidates.length;i++){
            List<Integer> doCombTemp = new ArrayList<>(temp);
            int tempSum = sum+candidates[i];
            if(tempSum<target){
                doCombTemp.add(candidates[i]);
                doComb(candidates,i,doCombTemp,tempSum,target);
            }else if(tempSum == target){
                doCombTemp.add(candidates[i]);
                result.add(doCombTemp);
                return;
            }else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum(new int[]{2,3,5},8);
    }
}
