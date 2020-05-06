package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @description:263. 丑数
 * @Date: 2020/5/5 15:04
 **/
public class IsUgly {
    public boolean isUgly(int num) {
        if(num == 1){
            return true;
        }
        boolean a2 =false;
        boolean a3 =false;
        boolean a5 =false;
        if(num%2==0){
            a2 = isUgly(num/2);
        }
        if(num%3==0){
            a3 = isUgly(num/3);
        }
        if(num%5==0){
            a5 = isUgly(num/5);
        }
        return a2||a3||a5;
    }

    public boolean isUgly2(int num){
        while (num!=1){
            if(num%2==0 || num%3==0 || num%5==0){
                if(num%2==0){
                    num/=2;
                }
                if(num%3==0){
                    num/=3;
                }
                if(num%5==0){
                    num/=5;
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
