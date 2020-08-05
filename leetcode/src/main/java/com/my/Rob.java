package com.my;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: shanghang
 * @Project:study
 * @description:337. 打家劫舍 III
 * @Date: 2020/8/5 22:56
 **/
public class Rob {
    /**
     * 打劫的收益
     */
    Map<TreeNode ,Integer > r = new HashMap<>();
    /**
     * 不打劫的收益
     */
    Map<TreeNode ,Integer > p = new HashMap<>();
    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(r.getOrDefault(root,0),p.getOrDefault(root,0));
    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.left);
        dfs(root.right);
        r.put(root,root.val+p.getOrDefault(root.left,0)+p.getOrDefault(root.right,0));
        p.put(root,Math.max(r.getOrDefault(root.left,0),p.getOrDefault(root.left,0))+Math.max(r.getOrDefault(root.right,0),p.getOrDefault(root.right,0)));
    }
}
