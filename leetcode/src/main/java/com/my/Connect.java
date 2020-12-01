package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @description:117. 填充每个节点的下一个右侧节点指针 II
 * @Date: 2020/9/28 22:51
 **/
public class Connect {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        if(root.left != null && root.right != null){
            root.left.next = root.right;
        }
        if(root.left!=null && root.right == null){
            root.left.next = getNext(root.next);
        }
        if (root.right != null){
            root.right.next = getNext(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node getNext(Node next) {
        if(next == null ){
            return null;
        }
        if(next.left != null){
            return next.left;
        }
        if(next.right != null){
            return next.right;
        }
        if(next.next != null){
            return getNext(next.next);
        }
        return null;
    }
}
