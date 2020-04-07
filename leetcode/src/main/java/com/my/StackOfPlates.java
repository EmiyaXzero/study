package com.my;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/7 11:33
 **/
public class StackOfPlates {
    private List<Stack<Integer>> plates;
    /**
     * 当前有几个栈
     */
    private int size = 0;
    private int limit;
    public StackOfPlates(int cap) {
        limit = cap;
        plates = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        plates.add(stack);
        size++;
    }

    public void push(int val) {
        if(limit<=0){
            return;
        }
        if(size == 0){
            Stack<Integer> stack = new Stack<>();
            stack.add(val);
            plates.add(stack);
            size++;
            return;
        }

        if(plates.get(size-1).size() <limit){
            plates.get(size-1).add(val);
        }else {
            Stack<Integer> stack = new Stack<>();
            stack.add(val);
            plates.add(stack);
            size++;
        }
    }

    public int pop() {
        if(limit<=0 || size == 0 || plates.get(size-1).size() == 0){
            return -1;
        }
        if(plates.get(size-1).size() == 1){
            int temp = plates.get(size-1).pop();
            plates.remove(size-1);
            size--;
            return temp;
        }else {
           return plates.get(size-1).pop();
        }
    }

    public int popAt(int index) {
        if(limit<=0 || index>=size){
            return -1;
        }
        if(plates.get(index).size() == 1){
            int temp = plates.get(index).pop();
            plates.remove(index);
            size--;
            return temp;
        }else {
            return plates.get(index).pop();
        }
    }

    public static void main(String[] args) {
        StackOfPlates stackOfPlates = new StackOfPlates(0);
        stackOfPlates.pop();
        stackOfPlates.pop();
        stackOfPlates.popAt(1);
        stackOfPlates.popAt(3);
        stackOfPlates.pop();
        stackOfPlates.push(40);
        stackOfPlates.push(10);
        stackOfPlates.push(44);
        stackOfPlates.push(44);
        stackOfPlates.pop();
        stackOfPlates.push(24);
        stackOfPlates.push(42);
        stackOfPlates.popAt(4);
        stackOfPlates.pop();
        stackOfPlates.popAt(0);
        stackOfPlates.pop();
        stackOfPlates.popAt(0);
        stackOfPlates.push(42);
        stackOfPlates.popAt(5);
        stackOfPlates.pop();
        stackOfPlates.push(29);
        stackOfPlates.pop();
        stackOfPlates.pop();
        stackOfPlates.pop();
        System.out.println(stackOfPlates.popAt(0));
        stackOfPlates.push(56);
        stackOfPlates.pop();
        stackOfPlates.popAt(4);
        stackOfPlates.pop();
    }
}
