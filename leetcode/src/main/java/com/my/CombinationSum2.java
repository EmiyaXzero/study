package com.my;

import java.util.*;

/**
 * @author shang
 * @title: CombinationSum2
 * @projectName study
 * @description: 组合总和 II
 * @date 2020/4/29-13:22
 */
public class CombinationSum2 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //先给数组排序
        Arrays.sort(candidates);
        for (int i = 0 ;i<candidates.length;i++){
            Deque<Integer> stack = new ArrayDeque();
            int sum = candidates[i];
            stack.add(candidates[i]);
            if(sum == target){
                result.add(new ArrayList<>(stack));
                return result;
            }else if(sum>target){
                return result;
            }
            doCombin(candidates,i+1,stack,sum,target);
            while (i < candidates.length-1 && candidates[i] == candidates[i+1]){
                i++;
            }
        }
        return result;
    }

    private void doCombin(int[] candidates, int idx, Deque<Integer> stack, int sum,int target) {
        if(idx==candidates.length){
            return;
        }
        for (int i = idx ;i<candidates.length;i++){
            //通过进栈出栈减少重复new的操作
            int tempSum = sum+candidates[i];
            stack.add(candidates[i]);
            if(tempSum == target){
                result.add(new ArrayList<>(stack));
                stack.removeLast();
                return;
            }else if(tempSum>target){
                stack.removeLast();
                return;
            }
            doCombin(candidates,i+1,stack,tempSum,target);
            //通过remove最后一位避免重新赋值
            stack.removeLast();

            while (i < candidates.length-1 && candidates[i] == candidates[i+1]){
                i++;
            }
        }

    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        combinationSum2.combinationSum2(new int[]{10,1,2,7,6,1,5},8);
    }
}
