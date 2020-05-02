package com.my;

import java.util.ArrayList;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5385. 改变一个整数能得到的最大差值
 * @Date: 2020/5/2 23:08
 **/
public class MaxDiff {
    public int maxDiff(int num) {
        ArrayList<Integer> allNums = new ArrayList<>();
        int temp  = num;
        while (temp!=0){
            if(temp%10 == 0){
            }
            allNums.add(temp%10);
            temp/=10;
        }
        int length = allNums.size();
        int a = 0 ,b = 0;
        //num头改成9
        int theFirstNot9 = length-1;
        int head = 0;
        while (theFirstNot9>=0){
            if(allNums.get(theFirstNot9) == 9 ){
                a = (int) (9*Math.pow(10,theFirstNot9)+a);
            }else {
                head = allNums.get(theFirstNot9);
                break;
            }
            theFirstNot9--;
        }
        for (int i = theFirstNot9;i>=0;i--){
            if(allNums.get(i) == head){
                a = (int) (9*Math.pow(10,i)+a);
            }else {
                a = (int) (allNums.get(i)*Math.pow(10,i)+a);
            }
        }
        theFirstNot9 = length-1;
        if(allNums.get(theFirstNot9) != 1){
            head = allNums.get(theFirstNot9);
            for (int i = theFirstNot9;i>=0;i--){
                if(allNums.get(i) == head){
                    b = (int) (1*Math.pow(10,i)+b);
                }else {
                    b = (int) (allNums.get(i)*Math.pow(10,i)+b);
                }
            }
        }else {
            //等于1的话得找到后面第一个不是0的
            b = (int) (1*Math.pow(10,theFirstNot9)+b);
            theFirstNot9--;
            while (true){
                if(allNums.get(theFirstNot9) != 0 && allNums.get(theFirstNot9) !=1){
                    head = allNums.get(theFirstNot9);
                    break;
                }else if(allNums.get(theFirstNot9) ==1){
                    b = (int) (1*Math.pow(10,theFirstNot9)+b);
                }
                theFirstNot9--;
            }
            for (int i = theFirstNot9;i>=0;i--){
                if(allNums.get(i) == head){

                }else {
                    b = (int) (allNums.get(i)*Math.pow(10,i)+b);
                }
            }
        }

        return a-b;
    }

    public static void main(String[] args) {
        MaxDiff maxDiff = new MaxDiff();
        System.out.println(maxDiff.maxDiff(1101057));
    }
}
