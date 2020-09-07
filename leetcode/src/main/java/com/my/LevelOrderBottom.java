package com.my;

import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @description:107. 二叉树的层次遍历 II
 * @Date: 2020/9/6 20:34
 **/
public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!= null){
                    queue.add(node.left);
                }
                if(node.right!= null){
                    queue.add(node.right);
                }
            }
            result.add(0,list);
        }
        return result;
    }


}
