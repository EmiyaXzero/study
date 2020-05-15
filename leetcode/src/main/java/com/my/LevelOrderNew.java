package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shang
 * @title: LevelOrderNew
 * @projectName study
 * @description: 102. 二叉树的层序遍历
 * @date 2020/5/13-1:34
 */
public class LevelOrderNew {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        doAdd(root,0,result);
        return result;
    }

    private void doAdd(TreeNode root, int i, List<List<Integer>> result) {
        if(root == null){
            return;
        }
        if(result.size()<=i){
            List<Integer> newList = new ArrayList<>();
            newList.add(root.val);
            result.add(newList);
        }else {
            result.get(i).add(root.val);
        }
        doAdd(root.left,i+1,result);
        doAdd(root.right,i+1,result);
    }
}
