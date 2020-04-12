package com.my;

import java.util.Arrays;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/9 23:02
 **/
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        //将数组拆分
        return createMinimalTree(nums,0,nums.length);
    }

    public TreeNode createMinimalTree(int[] nums,int left ,int right){
        int x = left+(right-left)/2;
        if(left == right){
            return null;
        }
        //中间节点为根节点
        TreeNode treeNode = new TreeNode(nums[x]);
        //left == right 搜索区间是[left,right)
        treeNode.left = createMinimalTree(nums,left,x);
        treeNode.right = createMinimalTree(nums,x+1,right);
        return treeNode;
    }

    public static void main(String[] args) {
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        sortedArrayToBST.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}
