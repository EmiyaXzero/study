package com.my;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shanghang
 * @title: HasPathSum
 * @projectName study
 * @description: 112. 路径总和
 * @date 2020/7/7-20:46
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        return doSum(root,0,sum);
    }

    public boolean doSum(TreeNode root  ,int curSum ,int target){
        if(root == null){
            return curSum == target;
        }
        curSum+= root.val;
        if(root.left!=null && root.right!=null){
            return doSum(root.left,curSum,target) || doSum(root.right,curSum,target);
        }else if(root.left!=null) {
            return doSum(root.left,curSum,target);
        }else if(root.right!=null){
            return doSum(root.right,curSum,target);
        }else{
            return curSum == target;
        }
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        HasPathSum hasPathSum = new HasPathSum();
        hasPathSum.hasPathSum(stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,null,1]"),22);
    }

}
