package com.my;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author: shanghang
 * @Project:study
 * @description:丑数Ⅱ三指针解法
 * @Date: 2020/5/5 11:55
 **/
public class NthUglyNumber3 {

    static int[] results = new int[1690];
    static {
        results[0] = 1;
        int ugly,x=0,y=0,z=0;
        for (int i = 1;i<1690;i++){
            //通过三指针的游动进行数组的添加，每次获取当前指针的最小值
            //例如当三指针都指向0的位置，我们可以获取到最小值为2，使x右移一位
            //右移之后说明此时只存在2*2于1*3和1*5对比取最小值当取到最小值3时说明1位置上只需要在跟5相乘做对比
            // 这时候再将y同时右移，x不右移的原因是还需要跟2*2进行对比，
            // 这样通过三指针的右移每次都会将1，3，5的乘值进行比较取最小，同时也不需要考虑int越界
            ugly = Math.min(Math.min(results[x]*2,results[y]*3),results[z]*5);
            results[i] = ugly;
            if(results[x]*2 == ugly){
                x++;
            }
            if(results[y]*3==ugly){
                y++;
            }
            if(results[z]*5==ugly){
                z++;
            }
        }
    }

    public int nthUglyNumber(int n) {
        return results[n-1];
    }

    public static void main(String[] args) {
        NthUglyNumber3 nthUglyNumber = new NthUglyNumber3();
        System.out.println(nthUglyNumber.nthUglyNumber(1690));
    }
}
