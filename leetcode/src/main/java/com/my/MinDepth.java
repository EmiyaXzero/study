package com.my;

/**
 * @author shang
 * @title: MinDepth
 * @projectName study
 * @description: 111. 二叉树的最小深度
 * @date 2020/5/13-2:40
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left == right && left == 0){
            return 1;
        }
        if (left == 0 || right>0){
            return right+1;
        }
        if(left >0 && right==0){
            return left+1;
        }
        return Math.min(left+1,right+1);
    }
}
