package com.my;

/**
 * @author shang
 * @title: InorderSuccessor
 * @projectName study
 * @description: 后继者
 * @date 2020/4/18-14:08
 */
public class InorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == p){
            //找到p节点
            return getRightMin(root.right);
        }
        if(p.val < root.val){
            //在root的左子树
            TreeNode treeNode ;
          if((treeNode = inorderSuccessor(root.left , p)) == null){
              return root;
          }else {
              return treeNode;
          }
        }else {
            return inorderSuccessor(root.right,p);
        }
    }

    public TreeNode getRightMin(TreeNode root){
       if(root == null){
           return null;
       }
       TreeNode tempNode = getRightMin(root.left);
       if(tempNode == null){
           return root;
       }else {
           return tempNode;
       }
    }

}
