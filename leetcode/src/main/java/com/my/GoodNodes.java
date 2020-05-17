package com.my;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5398. 统计二叉树中好节点的数目
 * @Date: 2020/5/16 22:44
 **/
public class GoodNodes {
    int result = 0;
    public int goodNodes(TreeNode root) {
        doDeepth(root,Integer.MIN_VALUE);
        return result;
    }

    private void doDeepth(TreeNode root, int maxValue) {
        if (root == null){
            return;
        }
        if(root.val>=maxValue){
            result++;
            maxValue = root.val;
        }
        doDeepth(root.left,maxValue);
        doDeepth(root.right,maxValue);
    }


}
