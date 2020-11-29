package com.my;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shanghang
 * @title: FindMode
 * @projectName study
 * @description: 501. 二叉搜索树中的众数
 * @date 2020/9/24-22:47
 */
public class FindMode {
    List<List<Integer>> values = new ArrayList<>();
    Map<Integer,Integer> all = new HashMap<>();
    public int[] findMode(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        dfs(root);
        return values.get(values.size()-1).stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        int newInt = all.getOrDefault(root.val,0)+1;
        if(values.size()<newInt){
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            values.add(temp);
        }else {
            List<Integer> temp = values.get(newInt-1);
            temp.add(root.val);
        }
        all.put(root.val,newInt);
        dfs(root.left);
        dfs(root.right);
    }

}
