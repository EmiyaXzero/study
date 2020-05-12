package com.my;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shang
 * @title: MinStackNew
 * @projectName study
 * @description: MinStackNew
 * @date 2020/5/12-9:06
 */
public class MinStackNew {
   static class MinStack{
       Deque<Integer> deque;
       Deque<Integer> minDeque;
       public MinStack() {
         deque = new ArrayDeque<>();
         minDeque = new ArrayDeque<>();
       }

       public void push(int x) {
            deque.add(x);
            if(minDeque.isEmpty()){
                minDeque.add(x);
            }else {
                int min = minDeque.getLast();
                minDeque.add(Math.min(min,x));
            }

       }

       public void pop() {
           if(!deque.isEmpty()){
               deque.removeLast();
               minDeque.removeLast();
           }
       }

       public int top() {
            return deque.getLast();
       }

       public int getMin() {
            return minDeque.getLast();
       }
   }

}
