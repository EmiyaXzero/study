package com.my;

import java.util.Stack;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/8 14:05
 **/
public class MyQueue {
    Stack<Integer> realStack ;
    Stack<Integer> tempStack;


    /** Initialize your data structure here. */
    public MyQueue() {
        realStack = new Stack<>();
        tempStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        realStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!realStack.isEmpty()){
            tempStack.push(realStack.pop());
        }
        int result = tempStack.pop();
        while (!tempStack.isEmpty()){
            realStack.push(tempStack.pop());
        }
        return result;
    }

    /** Get the front element. */
    public int peek() {
        while (!realStack.isEmpty()){
            tempStack.push(realStack.pop());
        }
        int result = tempStack.peek();
        while (!tempStack.isEmpty()){
            realStack.push(tempStack.pop());
        }
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return realStack.isEmpty();
    }
}
