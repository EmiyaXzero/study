package com.my;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
        // map方法，空间复杂度O(n)
        Node node = head;
        // 使用hash表存储旧结点和新结点的映射
        Map<Node,Node> map = new HashMap<>();
        while(node != null){
            Node clone = new Node(node.val,null,null);
            map.put(node,clone);
            node = node.next;
        }
        node = head;
        while(node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}
