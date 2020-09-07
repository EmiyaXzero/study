package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shanghang
 * @title: BinaryTreePaths
 * @projectName study
 * @description: 257. 二叉树的所有路径
 * @date 2020/9/4-9:17
 */
public class BinaryTreePaths {
    List<String> strings = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return new ArrayList<String>();
        }

        if(root.left == null && root.right ==null){
            strings.add(""+root.val);
        }else if(root.left == null){
            dfs( root.right,""+root.val);
        }else if(root.right == null){
            dfs( root.left,""+root.val);
        }else {
            dfs(root.left,""+root.val);
            dfs(root.right,""+root.val);
        }
        return strings;
    }

    public void dfs(TreeNode root , String s){

        if(root.left == null && root.right ==null){
            strings.add(s+"->"+root.val);
        }else if(root.left == null){
            dfs( root.right,s+"->"+root.val);
        }else if(root.right == null){
            dfs( root.left,s+"->"+root.val);
        }else {
            dfs( root.right,s+"->"+root.val);
            dfs( root.left,s+"->"+root.val);
        }
    }

}
