package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除链表的倒数第N个节点
 * @author shanghang
 */
public class RemoveNthFromEnd {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<ListNode>();
        while (head != null){
            //将每个节点塞到List
            nodes.add(head);
            head = head.next;
        }
        //取出list.size()-n
        int size = nodes.size();
        if(size == 1){
            return null;
        }
        if(size == n){
            return nodes.get(1);
        }
        if(n == 1){
            nodes.get(size-2).next = null;
        }else{
            nodes.get(size-n-1).next = nodes.get(size-n+1);
        }
        return nodes.get(0);
    }

    /**
     * 双指针
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        //不用哑节点会存在越界
        ListNode node = new ListNode(0);
        if(head == null || (head.next==null && n ==1)){
            return null;
        }
        node.next = head;
        ListNode nodeL = node;
        ListNode nodeR = node;
        //先让R移到n+1,让l在头
        for (int i = 1 ;i <= n+1  ;i++){
            nodeR = nodeR.next;
        }
        //当R移动到末尾，l就在n-1的地方
        while (nodeR!=null){
            nodeL = nodeL.next;
            nodeR = nodeR.next;
        }
        nodeL.next = nodeL.next.next;
        return node.next;
    }

        public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node .next = new ListNode(2);
//        node .next.next = new ListNode(3);
//        node .next.next.next = new ListNode(4);
//        node .next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEnd1(node, 2).toString());
    }
}
