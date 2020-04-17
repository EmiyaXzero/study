package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/14 22:27
 **/
public class InvertTree {
    //将头节点返回
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 方法一，直接换值不反回
     * @param treeNode
     */
    public void invert(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        if(treeNode.left == null && treeNode.right == null){
            return;
        }else if(treeNode.left == null){
            treeNode.left = treeNode.right;
            treeNode.right = null;
            invert(treeNode.left);
        }else if(treeNode.right == null){
            treeNode.right = treeNode.left;
            treeNode.left = null;
            invert(treeNode.right);
        }else {
            invert(treeNode.left);
            invert(treeNode.right);
            TreeNode tempNode = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = tempNode;
        }
    }

    public static void main(String[] args) {
        InvertTree invertTree = new InvertTree();
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);
        invertTree.invertTree(treeNode);
    }
}
