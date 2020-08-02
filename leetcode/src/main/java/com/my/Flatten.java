package com.my;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shang
 * @title: Flatten
 * @projectName study
 * @description: 扁平化多级双向链表
 * @date 2020/1/18-22:27
 */
public class Flatten {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public static Node flatten(Node head) {
        if(head==null){
            return head;
        }
        Node temp = head;
        List<Node> nextNode = new ArrayList<>();
        while (temp!=null){
            if(temp.child !=null){
                nextNode.add(temp.next);
                temp.next = temp.child;
                temp.child.prev = temp;
                temp.child = null;
            }
            if(temp.next != null) {
                temp = temp.next;
            }else {
                break;
            }
        }
        for (int i = nextNode.size()-1;i>=0;i--){
            if(nextNode.get(i) == null){
                continue;
            }
            while (temp.next !=null){
                temp = temp.next;
            }
            temp.next = nextNode.get(i);
            nextNode.get(i).prev = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        TreeNode treeNode = stringToTreeNode("[1,null,2,3]");
        new Flatten().flatten(treeNode);
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

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode left = root.left;
        flatten(left);
        if(left == null){
            flatten(root.right);
            return;
        }
        flatten(root.right);
        TreeNode right = doIt(left,root.right);
        root.left = null;
        root.right = right;
    }

    private TreeNode doIt(TreeNode left, TreeNode right) {
        TreeNode tempLeft = left;
        while (tempLeft.right != null){
            tempLeft =tempLeft.right;
        }
        tempLeft.right = right;
        return  left;
    }
}
