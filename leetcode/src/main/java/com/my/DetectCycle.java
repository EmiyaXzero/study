package com.my;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author shang
 * @title: DetectCycle
 * @projectName study
 * @description: 环形链表 II
 * @date 2020/1/16-14:56
 */
public class DetectCycle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        HashSet<ListNode> exists = new HashSet<>();
        ListNode temp = head;
        while (temp.next!=null){
            if(exists.contains(temp)){
                    return temp;
            }else {
                exists.add(temp);
            }
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node3;

        detectCycle(node);
    }
}
