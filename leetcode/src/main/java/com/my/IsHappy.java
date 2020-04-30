package com.my;

import java.util.HashSet;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/30 0:03
 **/
public class IsHappy {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n != 1){
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            int temp = 0;
            while ( n != 0){
                temp += Math.pow(n%10,2);
                n = n/10;
            }
            n = temp;
        }

        return true;
    }

    /**
     * 快慢指针
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
        int slow = n;
        int fast = n;
        //快慢指针要么都到循环点要么都到最终值1
        do {
           slow = getBitSum(slow);
           fast = getBitSum(fast);
           fast = getBitSum(fast);
        }while (slow != fast);
        return slow == 1;
    }

    public int getBitSum(int n){
        int sum = 0;
        while ( n != 0){
            sum += Math.pow(n%10,2);
            n = n/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();
        isHappy.isHappy(2);
    }
}
