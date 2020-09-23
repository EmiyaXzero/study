package com.my;

/**
 * @author shanghang
 * @title: MergeTrees
 * @projectName study
 * @description: 617. 合并二叉树
 * @date 2020/9/23-18:45
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode newTreeNode = dfs(t1,t2);
        return newTreeNode;
    }

    private TreeNode dfs(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        }else if(t1 == null){
            return t2;
        }else if(t2 == null){
            return t1;
        }
        TreeNode newTreeNode = new TreeNode(t1.val+t2.val);
        TreeNode newLeftNode = dfs(t1.left,t2.left);
        TreeNode newRightNode = dfs(t1.right,t2.right);
        newTreeNode.left = newLeftNode;
        newTreeNode.right = newRightNode;
        return newTreeNode;
    }
}
