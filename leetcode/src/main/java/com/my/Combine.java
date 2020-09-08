package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shanghang
 * @title: Combine
 * @projectName study
 * @description: 77. 组合
 * @date 2020/9/8-20:17
 */
public class Combine {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n,1,k,new ArrayList<Integer>());
        return result;
    }

    private void dfs(int n, int start, int k, ArrayList<Integer> integers) {
        if(integers.size() == k){
            result.add(integers);
            return;
        }
        for (int i = start ;i<=n; i++){
            ArrayList<Integer> list = new ArrayList<>(integers);
            list.add(i);
            int temp = Math.max(start+1,i);
            if (temp == i) {
                temp++;
            }
            dfs(n,temp,k,list);
        }
    }
}
