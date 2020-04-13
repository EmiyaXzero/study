package com.my;

import java.util.Stack;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/8 14:20
 **/
public class SortedStack {
    Stack<Integer> stack ;
    Stack<Integer> tempStack;

    public SortedStack() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(val);
        }else {
            if(val<=stack.peek()){
                stack.push(val);
            }else {
                //利用辅助栈找到比val大那个值
                while (!stack.isEmpty() && stack.peek()<val){
                    //直到栈空，或者找到比val大的
                    tempStack.push(stack.pop());
                }
                stack.push(val);
                while (!tempStack.isEmpty()){
                    stack.push(tempStack.pop());
                }
            }
        }
    }

    public void pop() {
        if(!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        if (!stack.isEmpty()){
            return stack.peek();
        }else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack s = new SortedStack();
        s.push(1);
        s.push(2);
    }
}
