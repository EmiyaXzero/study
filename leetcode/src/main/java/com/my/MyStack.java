package com.my;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/5/1 9:53
 **/
public class MyStack {
    private Deque<Integer> deque;

    /** Initialize your data structure here. */
    public MyStack() {
        this.deque = new ArrayDeque();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        this.deque.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return this.deque.removeLast();
    }

    /** Get the top element. */
    public int top() {
        return this.deque.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.deque.isEmpty();
    }
}
