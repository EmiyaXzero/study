package com.my;

import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/30 21:37
 **/
public class SubsetsWithDup {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result.add(new ArrayList<>());
        //把deque换成list快了1ms
        List<Integer> deque = new ArrayList<>();
        for (int i = 0 ;i<nums.length;i++){
            int finalI = i;
            result.add(new ArrayList<>(){{add(nums[finalI]);}});
            deque.add(nums[i]);
            doAdd(nums,i+1,deque);
            deque.remove(deque.size()-1);
            while (i<nums.length-1 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return result;
    }

    private void doAdd(int[] nums, int idx, List<Integer> integers) {
        for (int i = idx ;i<nums.length;i++){
            integers.add(nums[i]);
            //把deque换成list快了1ms,说明转换的时候拷贝deque to list慢
            result.add(new ArrayList<>(integers));
            doAdd(nums,i+1,integers);
            integers.remove(integers.size()-1);;
            while (i<nums.length-1 && nums[i] == nums[i+1]){
                i++;
            }
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        subsetsWithDup.subsetsWithDup(new int[]{1,2,2});
    }


}
