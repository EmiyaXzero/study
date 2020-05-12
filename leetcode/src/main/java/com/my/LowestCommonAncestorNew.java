package com.my;

/**
 * @author shang
 * @title: LowestCommonAncestorNew
 * @projectName study
 * @description: 235. 二叉搜索树的最近公共祖先
 * @date 2020/5/12-14:10
 */
public class LowestCommonAncestorNew {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null && right !=null){
            return right;
        }
        if (left != null && right == null){
            return left;
        }
        if(left != null && right !=null){
            return root;
        }
        return null;
    }
}
