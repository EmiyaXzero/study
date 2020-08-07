package com.my;

/**
 * @author shanghang
 * @title: IsSameTree
 * @projectName study
 * @description: 100. 相同的树
 * @date 2020/8/7-13:27
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if((p == null && q != null) ||(p != null && q == null)){
            return false;
        }else if(p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }else if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
