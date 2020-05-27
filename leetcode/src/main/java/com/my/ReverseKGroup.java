package com.my;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author shang
 * @title: ReverseKGroup
 * @projectName study
 * @description:  K 个一组翻转链表
 * @date 2020/5/16-12:59
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        Deque<ListNode> kDeque = new ArrayDeque<>();
        while (head != null){
            for (int i = 0 ;i<k;i++){
                if(head == null){
                    break;
                }
                kDeque.add(new ListNode(head.val));
                head = head.next;
            }
            if(kDeque.size() == k){
                while (!kDeque.isEmpty()){
                    temp.next = kDeque.removeLast();
                    temp = temp.next;
                }
            }else {
                while (!kDeque.isEmpty()){
                    temp.next = kDeque.removeFirst();
                    temp = temp.next;
                }
            }
        }
        return result.next;
    }

    /**
     * 原地反转
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroupFor(ListNode head, int k) {
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode pre = result;
        ListNode end = result;

        while (end.next!=null){
            //找到待翻转的终点k
            for (int i = 0 ;i<k && end!=null;i++){
                end = end.next;
            }
            if(end == null){
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            //end.next = null 将后续折断然后开始翻转
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }

        return result.next;
    }

    /**
     * 反转链表
     * @param start
     * @return
     */
    private ListNode reverse(ListNode start) {
        ListNode pre = null;
        ListNode curr = start;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args){
            String line = "[1,2,3,4,5]";
            ListNode head = stringToListNode(line);
            int k = 2;
            ListNode ret = new ReverseKGroup().reverseKGroupFor(head, k);
            String out = listNodeToString(ret);
            System.out.println(out);
    }
}
