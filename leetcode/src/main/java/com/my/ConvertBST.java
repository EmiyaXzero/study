package com.my;

/**
 * @author shanghang
 * @title: ConvertBST
 * @projectName study
 * @description: 538. 把二叉搜索树转换为累加树
 * @date 2020/9/21-18:35
 */
public class ConvertBST {
    int num = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root.right);
        root.val += num;
        num = root.val;
        dfs(root.left);
        return root.val;
    }
}
