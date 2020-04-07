package com.my;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/7 10:46
 **/
public class MinStack {
    /**
     * 两个栈，一个栈保存当前值，一个栈保存当前位置最小的值
     */
    public Stack<Integer> stack ;
    public Stack<Integer> minStack ;

    public MinStack() {

    }

    public void push(int x) {
        if(stack == null || stack.size() == 0){
            stack = new Stack<>();
            minStack = new Stack<>();
            stack.add(x);
            minStack.add(x);
        }else {
            stack.add(x);
            minStack.add(Math.min(x,minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(2147483646);
        s.push(2147483646);
        s.push(2147483646);
        s.top();
        s.top();
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.push(2147483647);
    }
}
