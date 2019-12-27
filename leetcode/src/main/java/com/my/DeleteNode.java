package com.my;

/**
 * 删除链表中的节点
 * @author shang
 */
public class DeleteNode {
    /**
     * 链表的删除只需要把next节点指定到下一个next的next
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
