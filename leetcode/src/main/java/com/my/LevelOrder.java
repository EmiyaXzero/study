package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shang
 * @title: LevelOrder
 * @projectName study
 * @description: 从上到下打印二叉树
 * @date 2020/4/28-13:58
 */
public class LevelOrder {
    List<List<Integer>> all = new ArrayList<>();
    int count = 0;
    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        doAdd(root,0);
        int[] result = new int[count];
        int k = 0;
        for (List<Integer> list : all){
            for (Integer integer : list){
                result[k++] = integer;
            }
        }
        return result;
    }

    public void doAdd(TreeNode root , int deep){
        if(root == null){
            return;
        }
        if(all.size()<=deep){
            all.add(new ArrayList<Integer>(){{add(root.val);}});

        }else {
            all.get(deep).add(root.val);
        }
        count++;
        doAdd(root.left,deep+1);
        doAdd(root.right,deep+1);
    }
}
