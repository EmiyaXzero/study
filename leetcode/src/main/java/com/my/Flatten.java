package com.my;

import java.util.ArrayList;
import java.util.List;

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
        Node node = new Node();
        node.val = 1;
        Node node1 = new Node();
        node1.val = 2;
        node.next = node1;
        node1.prev = node;
        Node node2 = new Node();
        node2.val = 3;
        node1.next = node2;
        node2.prev = node1;
        Node nodeChild = new Node();
        nodeChild.val = 4;
        node1.child = nodeChild;
        flatten(node);
    }
}
