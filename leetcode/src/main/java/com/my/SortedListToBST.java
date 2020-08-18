package com.my;

/**
 * @author shanghang
 * @title: SortedListToBST
 * @projectName study
 * @description: 109. 有序链表转换二叉搜索树
 * @date 2020/8/18-19:25
 */
public class SortedListToBST {
    /**
     * 链表中间的值为当前树跟节点
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }else if(head.next == null){
            return new TreeNode(head.val);
        }
        ListNode pre = head;
        ListNode p = pre.next, q = p.next;
        while (q!=null && q.next != null){
            pre = pre.next;
            p = p.next;
            q = q.next.next;
        }
        TreeNode headNode = new TreeNode(p.val);
        //将中间节点断开
        pre.next = null;
        headNode.left = sortedListToBST(head);
        headNode.right = sortedListToBST(p.next);
        return headNode;
    }
}
