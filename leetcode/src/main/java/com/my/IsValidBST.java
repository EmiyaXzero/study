package com.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/12 23:32
 **/
public class IsValidBST {
    private Integer i;

    /**
     * 中序遍历,是否递增(中序遍历先输出左节点，再输出当前节点后输出右节点)
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null ){
            return true;
        }
        //左节点不符合
        if(!isValidBST(root.left)){
            return false;
        }
        if(i!=null && root.val<=i){
            return false;
        }
        i = root.val;
        return isValidBST(root.right);
    }

    public boolean isValidBST2(TreeNode root) {
        return getIsVaildBST(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }

    /**
     * 中序遍历通过栈
     * @param root
     * @return
     */
    public boolean isValidBSTByStack(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        double inorder = - Double.MAX_VALUE;
        while (!deque.isEmpty() || root!=null){
            while (root != null){
                //将中间节点放进去
                deque.add(root);
                root = root.left;
            }
            //取出来中间节点值
            TreeNode treeNode = deque.removeLast();
            if(treeNode.val<=inorder){
                //中间节点值小于等于左节点值return false
                return false;
            }
            inorder = treeNode.val;
            root = treeNode.right;
        }
        return true;
    }


    public boolean getIsVaildBST(TreeNode root ,long max ,long min){
        if(root == null){
            return true;
        }
        if(root.val<=min || root.val>=max){
            return false;
        }
        //左树应该都比当前值小，右树应该都比当前值大
        return getIsVaildBST(root.left,root.val,min) && getIsVaildBST(root.right,max,root.val);
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        String line = "[2,1,3]";

            TreeNode root = stringToTreeNode(line);

            boolean ret = new IsValidBST().isValidBST2(root);

            String out = booleanToString(ret);

            System.out.print(out);

    }

}
