package com.my;

import java.util.List;

/**
 * @author shang
 * @title: MergeKLists
 * @projectName study
 * @description: 合并K个排序链表
 * @date 2020/4/26-8:59
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length<=0){
            return null;
        }
        for (int i =0 ;i<lists.length;i++){
            if (lists[i] == null){
                continue;
            }
            return doMerge(lists[i],lists,i+1);
        }
        return null;
    }


    /**
     * 优化方案分治合并，目前是暴力合并
     * @param result
     * @param lists
     * @param curIdx
     * @return
     */
    public ListNode doMerge(ListNode result ,ListNode[] lists , int curIdx){
        if(curIdx>=lists.length){
            return result;
        }
        ListNode temp = result;
        //前一个节点
        ListNode preNode = result;
        ListNode curNode = lists[curIdx];
        //用当前链表跟数组进行对比
        boolean isHead = true;
        while (temp!=null && curNode !=null){
            if(temp.val <curNode.val){
                isHead = false;
                while (temp.next != null &&temp.next.val<curNode.val){
                    temp = temp.next;
                }
                ListNode newNode = new ListNode(curNode.val);
                newNode.next = temp.next;
                preNode = temp;
                temp.next = newNode;
                temp = temp.next;
            }else {
                ListNode newNode = new ListNode(curNode.val);
                newNode.next = temp;
                if(isHead){
                    temp = newNode;
                    result = temp;
                }else {
                    preNode.next = newNode;
                    temp = preNode;
                }

            }
            curNode = curNode.next;
        }
        if(temp == null && curNode !=null){
            temp = curNode;
        }
        return doMerge(result,lists,curIdx+1);
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[2];
        ListNode temp = new ListNode(-3);
        temp.next = new ListNode(-3);
        temp.next.next = new ListNode(-2);
        lists[0] = temp;

        temp = new ListNode(-3);
        temp.next = new ListNode(-3);
        temp.next.next = new ListNode(-2);
        temp.next.next.next = new ListNode(-2);
        lists[1] = temp;
        temp = new ListNode(2);
        temp.next = new ListNode(6);
//        lists[2] = temp;
        MergeKLists mergeKLists = new MergeKLists();
        mergeKLists.mergeKLists(lists);
    }
}
