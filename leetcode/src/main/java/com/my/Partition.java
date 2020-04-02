package com.my;


/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/2 20:50
 **/
public class Partition {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);

        ListNode tempLeft = left;
        ListNode tempRight = right;
        while (head !=null){
            if(head.val <x){
                tempLeft.next = new ListNode(head.val);
                tempLeft = tempLeft.next;
            }else {
                tempRight.next = new ListNode(head.val);
                tempRight = tempRight.next;
            }
            head =head.next;
        }


        tempLeft.next = right.next;
        return left.next;
    }
}
