package com.my;

/**
 * 合并两个有序链表
 * @author shanghang
 */
public class MergeTwoLists {
   public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

       @Override
       public String toString() {
           ListNode tempNext = this.next;
           StringBuffer sb = new StringBuffer();
           sb.append(this.val);
           while (tempNext!=null){
               sb.append("->");
               sb.append(tempNext.val);
               tempNext = tempNext.next;
           }
           return sb.toString();
       }
   }

    /**
     * 1 ms	40.4 MB
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode resultNode = newNode;
        while (l1 != null && l2 !=null){
            if(l1.val <= l2.val ){
                ListNode tempNode = new ListNode(l1.val);
                newNode.next = tempNode;
                newNode = newNode.next;
                l1 = l1.next;
            }else{
                ListNode tempNode = new ListNode(l2.val);
                newNode.next = tempNode;
                newNode = newNode.next;
                l2 = l2.next;
            }
        }
        if(l1 == null){
            newNode.next = l2;
        }else {
            newNode.next = l1;
        }
        return resultNode.next;
    }

    /**
     * 递归,如果l1.val 小于l2.val 那么就是l1.val -> l1.next,那么递归l1.next与l2大小就好了
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode newNode1 = new ListNode(1);
        newNode1.next = new ListNode(2);
        newNode1.next.next = new ListNode(4);

        ListNode newNode2 = new ListNode(1);
        newNode2.next = new ListNode(3);
        newNode2.next.next = new ListNode(4);

        System.out.println(mergeTwoLists2(newNode1, newNode2));
    }
}
