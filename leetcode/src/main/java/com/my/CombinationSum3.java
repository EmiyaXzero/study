package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shanghang
 * @title: CombinationSum3
 * @projectName study
 * @description: 216. 组合总和 III
 * @date 2020/9/11-13:49
 */
public class CombinationSum3 {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1,9,k,n);
        return ans;
    }

    private void dfs(int cur, int n, int k, int sum) {
        if(temp.size()+(n-cur+1)<k || temp.size()>0){
            return;
        }
        if(temp.size() == k){
            int tempSum = 0;
            for (int num : temp){
                tempSum+=num;
            }
            if(tempSum == sum){
                ans.add(new ArrayList<Integer>(temp));
                return;
            }
        }
        temp.add(cur);
        dfs(cur+1,n,k,sum);
        temp.remove(temp.size()-1);
        dfs(cur+1,n,k,sum);
    }
}
