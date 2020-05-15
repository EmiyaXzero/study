package com.my;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shang
 * @title: ZigzagLevelOrder
 * @projectName study
 * @description: 103. 二叉树的锯齿形层次遍历
 * @date 2020/5/13-2:24
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        doAdd(root,0,result);
        return result;
    }

    private void doAdd(TreeNode root, int i, List<List<Integer>> result) {
        if(root == null){
            return;
        }
        if(result.size()<=i){
            LinkedList<Integer> newList = new LinkedList<>();
            newList.add(root.val);
            result.add(newList);
        }else {
            LinkedList temp = (LinkedList) result.get(i);
            if((i&1)==1){
                temp.addFirst(root.val);
            }else {
                temp.addLast(root.val);
            }
        }
        doAdd(root.left,i+1,result);
        doAdd(root.right,i+1,result);
    }
}
