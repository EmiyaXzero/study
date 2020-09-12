package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shanghang
 * @title: AverageOfLevels
 * @projectName study
 * @description: 637. 二叉树的层平均值
 * @date 2020/9/12-15:02
 */
public class AverageOfLevels {
    List<double[]> alls = new ArrayList<>();

    List<Double> result = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        dfs(root,0);
        return result;
    }

    private void dfs(TreeNode root, int i) {
        if(root == null) {
            return;
        }
        if(alls.size()>i){
            double[] temp = alls.get(i);
            temp[0]+=root.val;
            temp[1]++;
            result.set(i,temp[0]/temp[1]);
        }else {
            double[] temp = new double[]{root.val,1};
            result.add(temp[0]);
            alls.add(temp);
        }
        dfs(root.left,i+1);
        dfs(root.right,i+1);
    }
}
