package com.my;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: shanghang
 * @Project:study
 * @description:105. 从前序与中序遍历序列构造二叉树
 * @Date: 2020/5/22 20:59
 **/
public class BuildTree {
    Map<Integer,Integer> indexs = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       int preorderLength = preorder.length;
       int inorderLength = inorder.length;
       if (preorderLength!=inorderLength){
           return null;
       }
       for (int i = 0 ;i<inorder.length;i++){
           indexs.put(inorder[i],i);
       }

       return buildTree(preorder,0,preorderLength-1,0,inorderLength-1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
        if(preLeft>preRight || inLeft>inRight){
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode treeNode = new TreeNode(rootVal);
        treeNode.left = buildTree(preorder,preLeft+1,indexs.get(rootVal)-inLeft+preLeft,inLeft,indexs.get(rootVal)-1);
        treeNode.right = buildTree(preorder,indexs.get(rootVal)-inLeft+preLeft+1,preRight,indexs.get(rootVal)+1,inRight);
        return treeNode;
    }


    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        buildTree.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }
}
