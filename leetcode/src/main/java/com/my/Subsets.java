package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shanghang
 * @Project:study
 * @description:78. 子集
 * @Date: 2020/9/20 23:16
 **/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList());
        for(int i = 0;i<nums.length;i++){
            int all = res.size();
            for(int j = 0;j<all ;j++){
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }
}
