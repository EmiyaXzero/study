package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * 4 ms	44.1 MB
 * @author shang
 */
public class AddTwoNumbers {
    /**
     * 一开始思考错误以为第一位是最高位理解错了逆序的含义，导致将数字放在数组里面空位塞0，重复代码也比较多
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        List<Integer> a1 = new ArrayList<Integer>();
        List<Integer> a2 = new ArrayList<Integer>();
        while (null != l1){
            a1.add(l1.val);
            l1 = l1.next;
        }
        while (null != l2){
            a2.add(l2.val);
            l2 = l2.next;
        }
        ListNode listNode = null;
        ListNode tempListNode = null;
        boolean isCarry = false;
        if(a1.size() == a2.size()){
            for (int i = 0 ;i<a1.size();i++){
                if(i==0){
                    //需要判断进位
                    int result = a1.get(i)+a2.get(i);
                    if(result >=10){
                        result -= 10;
                        isCarry = true;
                    }
                    listNode = new ListNode(result);
                    tempListNode = listNode;
                }else{
                    //需要判断进位
                    int result = 0;
                    if(isCarry){
                        result = a1.get(i)+a2.get(i) +1;
                    }else{
                        result = a1.get(i)+a2.get(i);
                    }
                    if(result >=10){
                        result -= 10;
                        isCarry = true;
                    }else{
                        isCarry = false;
                    }
                    ListNode nextNode = new ListNode(result);
                    tempListNode.next = nextNode;
                    tempListNode = nextNode;
                }
            }
        }else if(a1.size()>a2.size()){
            int[] tempA2 = new int[a1.size()];
            for(int i =0 ; i<a1.size();i++){
                if( i < a2.size()){
                    tempA2[i] = a2.get(i);
                }else{
                    tempA2[i] = 0;
                }
            }
            for (int i = 0 ;i<a1.size();i++){
                if(i==0){
                    int result = a1.get(i)+tempA2[i];
                    if(result >=10){
                        result -= 10;
                        isCarry = true;
                    }
                    listNode = new ListNode(result);
                    tempListNode = listNode;
                }else{
                    //需要判断进位
                    int result = 0;
                    if(isCarry){
                        result = a1.get(i)+tempA2[i] +1;
                    }else{
                        result = a1.get(i)+tempA2[i];
                    }
                    if(result >=10){
                        result -= 10;
                        isCarry = true;
                    }else{
                        isCarry = false;
                    }
                    ListNode nextNode = new ListNode(result);
                    tempListNode.next = nextNode;
                    tempListNode = nextNode;
                }
            }
        }else if(a1.size()<a2.size()){
            int[] tempA1 = new int[a2.size()];
            for(int i =0 ; i<a2.size();i++){
                if( i < a1.size()){
                    tempA1[i] = a1.get(i);
                }else{
                    tempA1[i] = 0;
                }
            }
            for (int i = 0 ;i<a2.size();i++){
                if(i==0){
                    //需要判断进位
                    int result = a2.get(i)+tempA1[i];
                    if(result >=10){
                        result -= 10;
                        isCarry = true;
                    }
                    listNode = new ListNode(result);
                    tempListNode = listNode;
                }else{
                    //需要判断进位
                    int result = 0;
                    if(isCarry){
                        result = a2.get(i)+tempA1[i] +1;
                    }else{
                        result = a2.get(i)+tempA1[i];
                    }
                    if(result >=10){
                        result -= 10;
                        isCarry = true;
                    }else{
                        isCarry = false;
                    }
                    ListNode nextNode = new ListNode(result);
                    tempListNode.next = nextNode;
                    tempListNode = nextNode;
                }
            }
        }
        if(isCarry){
            //最后的时候如果还存在进位则加一个节点,需要使用tempListNode
            tempListNode.next = new ListNode(1);
        }

        return listNode;
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        //a1.next = new ListNode(8);
       // a1.next.next = new ListNode(3);
        ListNode a2 = new ListNode(9);
        a2.next = new ListNode(9);
      //  a2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers3(a1,a2);
        while (null != listNode.next){
            System.out.printf(""+ listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 官方方法
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    //递归算法
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return sum(l1,l2,0);
    }

    /**
     *
     * @param l1   第一个链表
     * @param l2    第二个链表
     * @param array     进位
     * @return
     */
    public ListNode sum(ListNode l1,ListNode l2,int array){
        int currentSum = l1.val + l2.val+array;
        ListNode currentNode = new ListNode(currentSum%10);
        if(l1.next == null && l2.next == null){
            //表示到顶了
            if(currentSum/10>0){
                currentNode.next = new ListNode(currentSum/10);
            }
            return currentNode;
        }
        //计算下一节点
        l1 = l1.next == null?new ListNode(0):l1.next;
        l2 = l2.next == null?new ListNode(0):l2.next;

        currentNode.next = sum(l1,l2,currentSum/10);
        return currentNode;
    }
}
