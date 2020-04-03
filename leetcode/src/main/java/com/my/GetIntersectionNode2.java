package com.my;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/3 11:18
 **/
public class GetIntersectionNode2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //hashSet保存
        ListNode a = headA;
        ListNode b= headB;
        Set<ListNode> set = new HashSet<>();
        while (a!=null){
            set.add(a);
            a = a.next;
        }
        while (b!=null){
            if(set.contains(b)){
                return b;
            }
            b =b.next;
        }
        return null;
    }

    /**
     *  两个链表如果有重复节点，则a链表遍历完再去遍历b链表，b链表遍历完再去遍历a链表最后会在重复节点相遇
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        //循环到找到重复节点，或者a,b两条链表遍历完，因为null 都是相等的
        while(a != b){
            if(a == null){
                a = headB;
            }else {
                a=a.next;
            }
            if(b == null){
                b = headA;
            }else {
                b=b.next;
            }
        }
        return a;
    }
}
