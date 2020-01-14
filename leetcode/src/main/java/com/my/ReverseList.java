package com.my;

/**
 * @author shang
 * @title: ReverseList
 * @projectName study
 * @description: TODO
 * @date 2020/1/14-15:19
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        //temp不动
        ListNode temp = new ListNode(1);
        //迭代
        while (head.next != null){
            ListNode node = new ListNode(head.val);
            if (temp.next != null) {
                node.next = temp.next;
            }
            temp.next = node;
            head = head.next;

        }
        ListNode node = new ListNode(head.val);
        node.next = temp.next;
        temp.next = node;
        return temp.next;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if(head == null){
            return head;
        }
        if(head.next == null){
            return new ListNode(head.val);
        }else{
            ListNode result = reverseList2(head.next);
            ListNode temp = result;
            while (temp.next !=null){
                temp = temp.next;
            }
            temp.next=new ListNode(head.val);
            return result;
        }
    }

    public static void main(String[] args) {
        ListNode node =new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        reverseList2(node);
    }
}
