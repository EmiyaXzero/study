package com.my;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shang
 * @title: LowestCommonAncestor
 * @projectName study
 * @description: 首个共同祖先
 * @date 2020/4/18-14:37
 */
public class LowestCommonAncestor {
    /**
     * 递归判断节点是在左还是在右
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null){
            return root;
        }
        if(left == null){
            return right;
        }else {
            return left;
        }
    }
    /**
     * 用hashMap存储父节点，然后遍历两个共同的父节点
     */

}
