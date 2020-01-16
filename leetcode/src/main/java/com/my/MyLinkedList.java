package com.my;

/**
 * @author shang
 * @title: MyLinkedList
 * @projectName study
 * @description: 设计链表
 * @date 2020/1/16-10:11
 */
public class MyLinkedList {
    public SingleNode head;
    public SingleNode tail;
    public int listIndex;
    class SingleNode {
        public int val;
        public SingleNode next;

        SingleNode(int val){
            this.val = val;
        }
    }
    /** Initialize your data structure here. */
    public MyLinkedList() {
        SingleNode node = new SingleNode(-99);
        this.head = node;
        this.tail = node;
        this.listIndex = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(listIndex == 0){
            return -1;
        }else {
            if(listIndex == 0){
                return head.val;
            }
            SingleNode temp = head;
            for (int i =1 ;i<=index;i++){
                if(temp.next != null){
                    temp = temp.next;
                }else {
                    return -1;
                }
            }
            return temp.val;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        SingleNode node = new SingleNode(val);
        if(listIndex == 0){
            head = node;
            tail = node;
            listIndex ++;
        }else{
            listIndex ++;
            node.next = head;
            head = node;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        SingleNode node = new SingleNode(val);
        if(listIndex == 0){
            head = node;
        }else{
            tail.next = node;
        }
        tail = node;
        listIndex ++;
    }


    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > listIndex){

        }else if(index == listIndex){
            addAtTail(val);
        }else if(index<=0){
            addAtHead(val);
            listIndex ++;
        }else {
            SingleNode temp = head;
            for (int i =1 ;i<index;i++){
                if(temp.next != null){
                    temp = temp.next;
                }
            }

            SingleNode nextTemp = temp.next;
            SingleNode node = new SingleNode(val);
            temp.next = node;
            node.next = nextTemp;
            listIndex ++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index == 0){
            head = head.next;
        }else if(index>0 && index<listIndex){
            SingleNode temp = head;
            for (int i =1 ;i<index;i++){
                if(temp.next != null){
                    temp = temp.next;
                }
            }
            SingleNode nextTemp = temp.next.next;
            temp.next = nextTemp;
            if(index == listIndex-1){
                tail = temp;
            }
            listIndex --;
        }
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(0);
        obj.addAtIndex(1,4);
        obj.addAtTail(8);
        obj.addAtHead(5);
        obj.addAtIndex(4,3);
        obj.addAtTail(0);
        obj.addAtTail(5);
        obj.addAtIndex(6,3);
        obj.deleteAtIndex(7);
        obj.deleteAtIndex(5);
    }
}
