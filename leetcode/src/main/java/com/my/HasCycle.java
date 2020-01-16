package com.my;

/**
 * @author shang
 * @title: HasCycle
 * @projectName study
 * @description: 环形链表
 * @date 2020/1/16-14:31
 */
public class HasCycle {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public static boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true){
            if(fast.next == null){
                return false;
            }else {
                fast = fast.next;
                if(fast.next == null){
                    return false;
                }else {
                    fast = fast.next;
                }
            }
            slow = slow.next;
            if(slow.next!=null && fast.next!=null){
                if(fast.val == slow.val && fast.next.val == slow.next.val){
                    return true;
                }
            }else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        hasCycle(node);
    }
}
