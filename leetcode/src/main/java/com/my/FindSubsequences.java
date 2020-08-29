package com.my;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shanghang
 * @title: FindSubsequences
 * @projectName study
 * @description: 491. 递增子序列
 * @date 2020/8/25-19:53
 */
public class FindSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length <= 1){
            return res;
        }
        findSub(res,new ArrayList<Integer>(),nums,0);
        return res;

    }

    private void findSub(List<List<Integer>> res, ArrayList<Integer> integers, int[] nums, int begin) {
        if(begin>nums.length){
            return;
        }
        int used = 233;
        if(integers.size()>=2){
            res.add(new ArrayList<>(integers));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = begin;i<nums.length;i++){
            if(set.contains(nums[i]) || nums[i] == used || (integers.size()>0 && integers.get(integers.size()-1)>nums[i])){
                continue;
            }
            integers.add(nums[i]);
            findSub(res,integers,nums,i+1);
            used = integers.remove(integers.size()-1);
            set.add(used);
        }
    }


}
