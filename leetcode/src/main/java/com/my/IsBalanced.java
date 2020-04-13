package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/9 23:40
 **/
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs(getLength(root.left)-getLength(root.right))>1){
            return false;
        }
        //得确保左子树的子树和右子树的子树也是平衡的
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getLength(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        return 1+Math.max(getLength(treeNode.left),getLength(treeNode.right));
    }
}
