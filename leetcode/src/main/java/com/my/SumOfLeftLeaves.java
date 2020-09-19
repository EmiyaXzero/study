package com.my;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: shanghang
 * @Project:study
 * @description:404. 左叶子之和
 * @Date: 2020/9/19 20:01
 **/
public class SumOfLeftLeaves {
    int result = 0;
    String Left = "left";
    String Right = "right";
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root,"root");
        return result;
    }

    private void dfs(TreeNode root, String leftOrRight) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(leftOrRight.equals(Left)){
                result+=root.val;
            }
            return;
        }
        dfs(root.left,Left);
        dfs(root.right,Right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = stringToTreeNode("[3,9,20,null,null,15,7]");
        new SumOfLeftLeaves().sumOfLeftLeaves(treeNode);
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
}
