package com.my;

/**
 * @author shang
 * @title: RotateRight
 * @projectName study
 * @description: 旋转链表
 * @date 2020/1/19-19:02
 */
public class RotateRight {
   public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }

    public ListNode rotateRight(ListNode head, int k) {
       if(head == null || k ==0){
           return head;
       }
       ListNode p = head;
       ListNode q = head;
       for (int i =0 ;i < k ;i++){
           if(q==null){
               q = head.next;
           }else {
               q = q.next;
           }
       }
       if(q == null){
           //正好一个循环
           return head;
       }
       while (q.next !=null){
           p = p.next;
           q = q.next;
       }

        ListNode result = p.next;
        p.next = null;
        q.next = head;
        return result;
    }

    /**
     * 将头尾连接起来，获取长度L，然后头尾移动L-K个单位，然后tail指向null
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight2(ListNode head, int k) {
        if(head == null || head.next ==null || k==0){
            return head;
        }
        ListNode tail = head;
        int l = 1;
        while (tail.next !=null){
            tail = tail.next;
            l++;
        }
        tail.next = head;
        ListNode newTail = head;
        for (int i = 0; i < (l-k%l-1); i++) {
            newTail = newTail.next;
        }
        ListNode result = newTail.next;
        newTail.next = null;
        return result;
    }
}
