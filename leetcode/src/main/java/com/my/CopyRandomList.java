package com.my;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author shang
 * @title: CopyRandomList
 * @projectName study
 * @description: 复制带随机指针的链表
 * @date 2020/1/18-23:22
 */
public class CopyRandomList {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };


    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        HashMap<Node,Node> head1 = new HashMap<>(16);
        HashMap<Node,Node> head2 = new HashMap<>(16);
        Node result = new Node(head.val,null,null);
        Node temp = result;
        head1.put(head.random,result);
        head2.put(result,head.random);
        head = head.next;
        while (head !=null){
            Node node = new Node(head.val,null,null);
            temp.next = node;
            temp = temp.next;
            head1.put(head.random,temp.next);
            head2.put(temp.next,head.random);
            if(head1.containsKey(head)){
                head2.put(head1.get(head),temp);
            }
        }
        Node temp2 = result;
        while (temp2 !=null){
            temp2.random = head2.get(temp2);
        }

        return result;
    }
}
