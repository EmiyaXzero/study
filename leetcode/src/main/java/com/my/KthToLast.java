package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/1 14:22
 **/
public class KthToLast {
    public int kthToLast(ListNode head, int k) {
        //双指针
        ListNode a = head;
        ListNode b = head;
        for (int i =1 ; i<k;i++){
            b = b.next;
        }
        while (b.next != null){
            a =a.next;
            b = b.next;
        }
        return a.val;
    }
}
