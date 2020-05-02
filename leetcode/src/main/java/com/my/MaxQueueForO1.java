package com.my;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: shanghang
 * @Project:study
 * @description:面试题59 - II. 队列的最大值 时间复杂度均为1的解法
 * @Date: 2020/5/2 14:21
 **/
public class MaxQueueForO1 {


    class MaxQueue{
        /**
         * 保存所有值
         */
        Deque<Integer> deque ;
        /**
         * 辅助队列来保存影响值
         */
        Deque<Integer> maxValueDeque;

        public MaxQueue() {
            this.deque = new ArrayDeque<>();
            this.maxValueDeque = new ArrayDeque<>();
        }

        public int max_value() {
            //辅助队列队头就是当前数最大值
            return maxValueDeque == null || maxValueDeque.isEmpty() ?-1:maxValueDeque.getFirst();
        }

        public void push_back(int value) {
            if(deque.isEmpty()){
                maxValueDeque.add(value);
            }else {
                //因为后续的大小只会影响到前面的并不会影响到后面的后面
                boolean isAdd = false;
                while (!maxValueDeque.isEmpty()){
                    if (maxValueDeque.getLast()<value){
                        maxValueDeque.removeLast();
                    }else {
                        isAdd = true;
                        maxValueDeque.add(value);
                        break;
                    }
                }
                if(!isAdd){
                    maxValueDeque.add(value);
                }
            }
            deque.add(value);
        }

        public int pop_front(){
            if(deque.isEmpty()){
                return -1;
            }
            if (deque.getFirst().equals(maxValueDeque.getFirst())){
                maxValueDeque.removeFirst();
            }
            return deque.removeFirst();
        }

    }

}
