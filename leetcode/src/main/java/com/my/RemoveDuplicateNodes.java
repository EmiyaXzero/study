package com.my;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/1 13:40
 **/
public class RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null || head.next ==null){
            return head;
        }
        Set<Integer> temp = new HashSet<Integer>();
        ListNode first = head;
        ListNode second = first.next;
        temp.add(first.val);
        while(second !=null){
            int key = second.val;
            if(temp.contains(key)){
                while(second.next != null && temp.contains(second.next.val)){
                    second = second.next;
                }
                second = second.next;
                first.next = second;
                first = first.next;
            }else {
                temp.add(key);
                first = second;
                second = second.next;
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
