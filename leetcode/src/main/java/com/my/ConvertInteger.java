package com.my;

/**
 * @author shang
 * @title: ConvertInteger
 * @projectName study
 * @description: 面试题 05.06. 整数转换
 * @date 2020/4/29-10:59
 */
public class ConvertInteger {
    public int convertInteger(int A, int B) {
        int count = 0;
        while ( A != 0 && B != 0){
            if(((A&1)^(B&1)) == 1){
                //异或运算不等为1
                count++;
            }
            //无符号右移让负数也右移
            A >>>=1;
            B >>>=1;
        }
        while (A!=0){
            if((A&1) == 1){
                count++;
            }
            A >>>=1;
        }
        while (B!=0){
            if((B&1) == 1){
                count++;
            }
            B >>>=1;
        }
        return count;
    }

    public static void main(String[] args) {
        ConvertInteger convertInteger = new ConvertInteger();
        convertInteger.convertInteger(826966453,
                -729934991);
    }
}
