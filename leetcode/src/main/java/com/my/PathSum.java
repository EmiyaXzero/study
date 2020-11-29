package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shanghang
 * @Project:study
 * @description:113. 路径总和 II
 * @Date: 2020/9/26 23:54
 **/
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        if(root.val == sum && root.left == null && root.right ==null){
            List<Integer> arr = new ArrayList<>();
            arr.add(root.val);
            ans.add(arr);
            return ans;
        }
        List<List<Integer>> left = pathSum(root.left,sum - root.val);
        List<List<Integer>> right = pathSum(root.right,sum - root.val);
        for(List<Integer> list : left){
            list.add(0,root.val);
            ans.add(list);
        }
        for(List<Integer> list : right){
            list.add(0,root.val);
            ans.add(list);
        }
        return ans;
    }
}
