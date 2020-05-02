package com.my;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * @Author: shanghang
 * @Project:study
 * @description:面试题59 - II. 队列的最大值
 * @Date: 2020/5/2 13:17
 **/
public class MaxQueue {
    class MaxQueueNode{
        int curInt;
        //只保存当前值后面的前面不管
        Deque<Integer> maxQueue;

        public MaxQueueNode(int curInt , Deque<Integer> deque){
            this.curInt = curInt;
            this.maxQueue = deque;
        }
    }

    Deque<MaxQueueNode> deque ;

    public MaxQueue() {
        this.deque = new ArrayDeque<>();
    }

    public int max_value() {
        return deque == null || deque.isEmpty() ?-1:deque.getFirst().maxQueue.getLast();
    }

    public void push_back(int value) {
        if (deque != null && !deque.isEmpty()) {
            Deque<MaxQueueNode> tempDeque = this.deque;
            Iterator<MaxQueueNode> iterator = tempDeque.iterator();
            while (iterator.hasNext()){
                MaxQueueNode lastQueueNode = iterator.next();
                Deque<Integer> maxLatMaxDeque = lastQueueNode.maxQueue;
                if (maxLatMaxDeque.getLast() < value) {
                    maxLatMaxDeque.add(value);
                }
            }
        }
        deque.addLast(new MaxQueueNode(value,new ArrayDeque<>(){{add(value);}}));
    }

    public int pop_front() {
        return deque != null && !deque.isEmpty()?deque.removeFirst().curInt:-1;
    }
}
