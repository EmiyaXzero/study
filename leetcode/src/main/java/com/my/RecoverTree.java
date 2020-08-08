package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @description:99. 恢复二叉搜索树
 * @Date: 2020/8/8 21:17
 **/
public class RecoverTree {
    TreeNode t1 ;
    TreeNode t2 ;
    TreeNode pre;
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }

    private void inOrder(TreeNode root) {
        if(root == null){
            return;
        }
        inOrder(root.left);
        if(pre != null && pre.val >root.val){
            if(t1 == null){
                t1 = pre;
            }
            t2 = root;
        }
        pre = root;
        inOrder(root.right);
    }


}
