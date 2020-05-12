package com.my;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shang
 * @title: SuperPow
 * @projectName study
 * @description: 超级次方
 * @date 2020/5/12-9:16
 */
public class SuperPow {
    int base = 1337;
    public int superPow(int a, int[] b) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int n : b){
            deque.add(n);
        }
        return superPow(a,deque);
    }

    public int superPow(int a, Deque<Integer> b) {
        //b是空
        if(b.isEmpty()) {
            return 1;
        }
        int lastB = b.removeLast();
        int part1 = pow(a,lastB);
        //递归拆分数组a^[1,5,6,4] = a^4*a^[1,5,6,0] = a^4*(a^[1,5,6])^10
        int part2 = pow(superPow(a,b),10);
        //(a * b) % k = (a % k)(b % k) % k
        return (part1*part2)%base;
    }

    public int pow(int a,int x){
        if(x == 0){
            return 1;
        }
        a%=base;
        if(x%2==0){
            //偶数
            int result = pow(a,x/2);
            return (result*result)%base;
        }else {
            //奇数
            int result = pow(a,(x-1));
            return (result*a)%base;
        }
    }

    public static void main(String[] args) {
        SuperPow s = new SuperPow();
        System.out.println(s.superPow(2147483647, new int[]{2, 0,0}));
    }
}
