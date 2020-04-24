package com.my;

/**
 * @author shang
 * @title: CountNodes
 * @projectName study
 * @description: 完全二叉树的节点个数
 * @date 2020/4/24-18:16
 */
public class CountNodes {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left+right+1;
    }
}
