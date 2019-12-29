package com.my;

/**
 * 两两交换链表中的节点
 * @author shanghang
 */
public class SwapPairs {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode swapPairs(ListNode head) {
        //防止空节点或一个节点
        if(head == null || head.next == null){
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        //交换节点head->p->q  head->next = q q->next = p
        ListNode first = result;
        ListNode p = result.next;
        ListNode q = result.next.next;
        boolean isChange = true;
        while (q !=null){
            if(isChange){
                ListNode tempList = q.next;
                first.next = q;
                p.next = tempList;
                q.next = p;
                //p = q ,q = p
                ListNode tempNode = p;
                p = q;
                q = tempNode;
                //然后右移两位
                first = first.next;
                p = p.next;
                q = q.next;
                isChange =false;
            }else {
                first = first.next;
                p = p.next;
                q = q.next;
                isChange =true;
            }

        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode result = new ListNode(1);
        result.next = new ListNode(2);
        result.next.next = new ListNode(3);
        result.next.next.next = new ListNode(4);
        System.out.println(swapPairs(result).toString());

    }
}
