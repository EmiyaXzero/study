package com.my;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shang
 * @title: BuildTree
 * @projectName study
 * @description: 105. 从前序与中序遍历序列构造二叉树
 * @date 2020/5/22-13:31
 */
public class BuildTree {
    /**
     *
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return 二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length<=0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        if(preorder.length == 1){
            return root;
        }
        int i = 1,j=0;
        while (preorder[i]!=inorder[j]){

        }

        return root;
    }
}
