package com.my;

import java.util.ArrayList;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/12 23:32
 **/
public class IsValidBST {
    private Integer i;

    /**
     * 前序遍历,是否递增(前序遍历先输出左节点，再输出当前节点后输出右节点)
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null ){
            return true;
        }
        //左节点不符合
        if(!isValidBST(root.left)){
            return false;
        }
        if(i!=null && root.val<=i){
            return false;
        }
        i = root.val;
        return isValidBST(root.right);
    }



}
