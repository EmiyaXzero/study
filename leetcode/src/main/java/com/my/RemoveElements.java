package com.my;

/**
 * @author shang
 * @title: RemoveElements
 * @projectName study
 * @description: 移除链表元素
 * @date 2020/1/17-15:05
 */
public class RemoveElements {
    /**
     * 定义两个指针p,q p=head q=head.next 如果q!=val p.next q.next
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        //首先将head.val ==val的情况排除
        while (head != null && head.val == val){
            head =head.next;
        }
        if(head == null){
            return null;
        }
        ListNode p = head;
        ListNode q = head.next;
        while (q!=null){
            if(q.val==val){
                while(q !=null && q.val == val){
                    q = q.next;
                }
                p.next = q;
                if(q==null || q.next == null){
                    break;
                }else {
                    q = q.next;
                }
            }else{
                q = q.next;
            }
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next = new ListNode(6);
        removeElements(node,6);
    }
}
