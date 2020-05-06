package com.my;

import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @description:丑数
 * @Date: 2020/5/5 11:55
 **/
public class NthUglyNumber {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Comparator.naturalOrder());
    List<Integer> resultS = new ArrayList<>();
    public int nthUglyNumber(int n) {
        if(priorityQueue.isEmpty()){
            Set<Integer> integers = new HashSet<>();
            Deque<Integer> deque = new ArrayDeque<>();
            deque.add(1);
            priorityQueue.add(1);
            integers.add(1);
            while (!deque.isEmpty()){
                int temp = deque.removeFirst();
                int temp2 = temp*2;
                int temp3 = temp*3;
                int temp5 = temp*5;
                if (temp == 536870912){
                    int aaa = 1;
                }
                if(temp2<temp){
                    continue;
                }
                if(!integers.contains(temp2) && temp2>temp){
                    deque.add(temp2);
                    priorityQueue.add(temp2);
                    integers.add(temp2);
                }
                if(!integers.contains(temp3) && temp3>temp){
                    deque.add(temp3);
                    priorityQueue.add(temp3);
                    integers.add(temp3);
                }
                if(!integers.contains(temp5) && temp5>temp){
                    deque.add(temp5);
                    priorityQueue.add(temp5);
                    integers.add(temp5);
                }
            }
            for (int i = 0 ;i<1690;i++){
                resultS.add(priorityQueue.poll());
            }
        }
        return resultS.get(n-1);
    }

    public static void main(String[] args) {
        NthUglyNumber nthUglyNumber = new NthUglyNumber();
        System.out.println(nthUglyNumber.nthUglyNumber(1690));
    }
}
