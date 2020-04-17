package com.my;

import java.util.Stack;

/**
 * @author shang
 * @title: AddTwoNumbers2
 * @projectName study
 * @description:
 * @date 2020/4/14-9:04
 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (temp1 !=null && temp2!=null){
            s1.add(temp1.val);
            s2.add(temp2.val);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while (temp1!=null){
            s1.add(temp1.val);
            temp1 = temp1.next;
        }
        while (temp2!=null){
            s2.add(temp2.val);
            temp2 = temp2.next;
        }
        int tempA = s1.pop();
        int tempB = s2.pop();
        ListNode result = new ListNode((tempA+tempB)%10);
        int jin = (tempA+tempB)/10;
        while (!s1.isEmpty() && !s2.isEmpty()){
            tempA = s1.pop();
            tempB = s2.pop();
            ListNode tempNode = new ListNode((tempA+tempB+jin)%10);
            tempNode.next = result;
            jin = (tempA+tempB+jin)/10;
            result = tempNode;
        }
        while (!s1.isEmpty()){
            tempA = s1.pop();
            ListNode tempNode = new ListNode((tempA+jin)%10);
            tempNode.next = result;
            jin = (tempA+jin)/10;
            result = tempNode;
        }
        while (!s2.isEmpty()){
            tempA = s2.pop();
            ListNode tempNode = new ListNode((tempA+jin)%10);
            tempNode.next = result;
            jin = (tempA+jin)/10;
            result = tempNode;
        }
        if(jin>0){
            ListNode tempNode = new ListNode(jin);
            tempNode.next = result;
            result = tempNode;
        }
        return result;
    }


}
