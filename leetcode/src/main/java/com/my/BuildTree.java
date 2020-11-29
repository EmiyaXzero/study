package com.my;


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

    /**
     * 中序和后序
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        return helper(inorder,postorder,postorder.length-1,0,inorder.length-1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int postEnd, int inStart, int inEnd) {
        if(inStart>inEnd){
            return null;
        }
        int currentVal = postorder[postEnd];
        int inIndex = 0;
        TreeNode currentTree = new TreeNode(currentVal);
        for(int i = inStart ;i<=inEnd;i++){
            if(inorder[i] == postorder[postEnd]){
                inIndex = i;
            }
        }
        //postEnd取减去右节点的数量
        TreeNode currentLeft = helper(inorder, postorder, postEnd - (inEnd- inIndex) - 1, inStart, inIndex-1);
        TreeNode currentRight = helper(inorder, postorder, postEnd -1, inIndex+1, inEnd);

        currentTree.left = currentLeft;
        currentTree.right = currentRight;
        return currentTree;
    }
}
