package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @description: 二叉树的直径
 * @Date: 2020/5/4 17:59
 **/
public class DiameterOfBinaryTree {
    int maxDepth = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depth = 0;
        depth = getDepth(root.left)+getDepth(root.right);
        maxDepth = Math.max(maxDepth,depth);
        return maxDepth;
    }

    public int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        maxDepth = Math.max(maxDepth,leftDepth+rightDepth);
        return Math.max(leftDepth,rightDepth)+1;
    }
}
