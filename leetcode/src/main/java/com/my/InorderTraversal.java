package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shanghang
 * @title: InorderTraversal
 * @projectName study
 * @description: 94. 二叉树的中序遍历
 * @date 2020/9/14-20:09
 */
public class InorderTraversal {
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.left);
        result.add(root.val);
        dfs(root.right);
    }
}
