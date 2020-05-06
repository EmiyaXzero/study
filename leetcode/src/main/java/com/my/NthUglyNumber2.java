package com.my;

import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @description:优先队列解决丑数，每次都从优先队列队头开始，因为每一次都是最小的
 * @Date: 2020/5/5 11:55
 **/
public class NthUglyNumber2 {

    static int[] results = new int[1690];
    static {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Comparator.naturalOrder());
        Set<Integer> integers = new HashSet<>();
        priorityQueue.add(1);
        integers.add(1);
        for (int i = 0 ;i<1690;i++){
            int temp = priorityQueue.poll();
            results[i] = temp;
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
                priorityQueue.add(temp2);
                integers.add(temp2);
            }
            if(!integers.contains(temp3) && temp3>temp){
                priorityQueue.add(temp3);
                integers.add(temp3);
            }
            if(!integers.contains(temp5) && temp5>temp){
                priorityQueue.add(temp5);
                integers.add(temp5);
            }
        }
    }

    public int nthUglyNumber(int n) {
        return results[n-1];
    }

    public static void main(String[] args) {
        NthUglyNumber2 nthUglyNumber = new NthUglyNumber2();
        System.out.println(nthUglyNumber.nthUglyNumber(1690));
    }
}
