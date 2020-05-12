package com.my;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shang
 * @title: IsSubtree
 * @projectName study
 * @description: 572. 另一个树的子树
 * @date 2020/5/7-14:01
 */
public class IsSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Deque<TreeNode> treeNodes = new ArrayDeque<>();
        isHasTHead(s,t,treeNodes);
        while (!treeNodes.isEmpty()){
            TreeNode treeNode = treeNodes.removeFirst();
            if(isSubtreeTrue(treeNode,t)){
                return true;
            }
        }
        return false;
    }

    private void isHasTHead(TreeNode s, TreeNode t, Deque<TreeNode> treeNodes) {
        if(s == null){
            return;
        }
        if(s.val == t.val){
            treeNodes.add(s);
        }
        isHasTHead(s.left,t,treeNodes);
        isHasTHead(s.right,t,treeNodes);
    }

    public boolean isSubtreeTrue(TreeNode s,TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if(s == null && t != null || s!=null && t==null ){
            return false;
        }
        if(s.val == t.val){
            return isSubtreeTrue(s.left,t.left) && isSubtreeTrue(s.right,t.right);
        }else {
            return false;
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
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
            TreeNode s = stringToTreeNode("[3,4,5,1,2]");
            TreeNode t = stringToTreeNode("[4,1,2]");

            boolean ret = new IsSubtree().isSubtree(s, t);


    }

}
