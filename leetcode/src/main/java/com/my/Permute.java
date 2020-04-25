package com.my;

import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/25 10:19
 **/
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length<=0){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        dfs(nums,0,stack,used,result);

        return result;

        //return doPermute(nums,0);
    }

    public List<List<Integer>> doPermute(int[] nums ,int start){
        if(start == nums.length-1){
            return new ArrayList<>(){{ add(new ArrayList<>(){{add(nums[start]);}});}};
        }else{
            List<List<Integer>> temp = doPermute(nums,start+1);
            List<List<Integer>> result = new ArrayList<>();
            for (int i =0 ;i<temp.size();i++){
                for (int j = 0;j<=temp.get(i).size();j++){
                    //new 是为了防止使用的temp.get(i)的引用
                    List<Integer> tempNode = new ArrayList<>(temp.get(i));
                    tempNode.add(j,nums[start]);
                    result.add(tempNode);
                }
            }
            return result;
        }
    }

    /**
     * 深度优先算法，回溯
     * @param nums 遍历的数组
     * @param depth 树的深度
     * @param path  当前的排列路径
     * @param used  是否已经使用过
     * @param result 返回的结果
     */
    public void dfs(int[] nums, int depth , Deque path,boolean[] used,List<List<Integer>> result){
        if(depth == nums.length){
            //重新new一次防止引用的赋值
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0 ;i<nums.length ;i++){
            //已经访问过就继续下一个
            if (used[i]){
                continue;
            }
            //当前值入栈
            path.addLast(nums[i]);
            //状态置为已访问
            used[i] = true;
            dfs(nums,depth+1,path,used,result);
            //回溯的时候状态重置
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        permute.permute(new int[]{1,2,3});
    }

}
