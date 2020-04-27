package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shang
 * @title: CreateTargetArray
 * @projectName study
 * @description: TODO
 * @date 2020/4/27-14:29
 */
public class CreateTargetArray {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(index[i]>result.size()){
                result.add(nums[i]);
            }else {
                result.add(index[i],nums[i]);
            }
        }
        //耗时1ms
        int[] target = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            target[i] = result.get(i);
        }
        //耗时4ms
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

}
