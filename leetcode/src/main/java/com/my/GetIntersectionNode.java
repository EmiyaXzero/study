package com.my;

import java.util.HashSet;

/**
 * @author shang
 * @title: GetIntersectionNode
 * @projectName study
 * @description: 相交链表
 * @date 2020/1/17-14:33
 */
public class GetIntersectionNode {
    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null || tempB !=null){
            set.add(tempA);
            tempA = tempA.next;
        }
        while (tempB !=null){
            //set.contains太耗时要减少使用
            if(set.contains(tempB)){
                return tempB;
            }
            tempB = tempB.next;
        }
        return null;
    }

    /**
     * 但是细想就会发现很简单很巧妙 A和B两个链表长度可能不同，但是A+B和B+A的长度是相同的，
     * 所以遍历A+B和遍历B+A一定是同时结束。 如果A,B相交的话A和B有一段尾巴是相同的，
     * 所以两个遍历的指针一定会同时到达交点 如果A,B不相交的话两个指针就会同时到达A+B（B+A）的尾节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA,ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA!=tempB){
            //如果temp跟tempB没有交集那么tempA到tempB，TempB到TempA最后会同时到达null
            tempA = tempA == null ?headB:tempA.next;
            tempB = tempB == null ?headA:tempB.next;
        }
        return tempA;
    }
}
