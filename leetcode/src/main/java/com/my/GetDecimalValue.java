package com.my;

import java.util.ArrayList;

public class GetDecimalValue {
    public static int getDecimalValue(ListNode head) {
        int max = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(null !=head){
            list.add(head.val);
            head = head.next;
        }
        for (int i = list.size() ;i>0 ;i--){
            if(list.get(list.size()-i) == 1){
                max+= Math.pow(2,i-1);
            }
        }
        return  max;
    }
    public static int getDecimalValue2(ListNode head) {
        //位运算
        int i = 0;
        while (null !=head){
            i<<=1;
            i+=head.val;
            head = head.next;
        }
        return i;
    }

        public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next=new ListNode(0);
        listNode.next.next =new ListNode(0);
        System.out.println(getDecimalValue2(listNode));
    }
}
