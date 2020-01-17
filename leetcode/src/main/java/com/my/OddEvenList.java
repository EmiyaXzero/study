package com.my;

/**
 * @author shang
 * @title: OddEvenList
 * @projectName study
 * @description: 奇偶链表
 * @date 2020/1/17-15:35
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next ==null){
            return head;
        }
        ListNode ji = head;
        ListNode ou = head.next;
        ListNode resultOu = ou;
        while (ou !=null){
            ji.next = ou.next;
            if(ji.next!=null) {
                ji = ji.next;
            }
            if(ou.next!=null){
                ou.next = ou.next.next;
            }
            ou = ou.next;
        }
        ji.next = resultOu;
        return head;
    }
}
