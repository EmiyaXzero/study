package com.my;


import java.util.ArrayList;
import java.util.List;

/**
 * @author shang
 * @title: RightSideView
 * @projectName study
 * @description: TODO
 * @date 2020/4/22-0:25
 */
public class RightSideView {
    List<List<Integer>> deepLength = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        int deepSize = 0;
        List<Integer> result = new ArrayList<>();
        setDeepLength(root,1);
        for (List<Integer> list : deepLength) {
            result.add(list.get(list.size()-1));
        }
        return result;
    }

    public void setDeepLength(TreeNode root,int deepSize){
        if(root == null){
            return;
        }
        if(deepLength.size()<deepSize){
            List<Integer> tempList = new ArrayList<>();
            tempList.add(root.val);
            deepLength.add(tempList);
        }else {
            deepLength.get(deepSize-1).add(root.val);
        }
        //先遍历左节点，再遍历右节点确保右节点的值在最后一位
        setDeepLength(root.left,deepSize+1);
        setDeepLength(root.right,deepSize+1);
    }
}
