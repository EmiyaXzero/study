package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/19 22:41
 **/
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode rootLeft = mirrorTree(root.left);
        TreeNode rootRight = mirrorTree(root.right);
        TreeNode temp = rootLeft;
        root.left = rootRight;
        root.right = temp;
        return root;
    }
}
