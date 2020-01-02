package com.my;

import java.util.ArrayList;

/**
 * 加一
 * @author shang
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        //防止digits+1溢出了比如9999+1  10000,result不一定能用到
        int[] result = new int[digits.length+1];
        //先把digits转成int
        int length = digits.length;
        int end = 1;
        for (int i = length - 1 ;i>=0 ;i--){
            int add = digits[i]+1;
            if(add > 9){
                digits[i] = 0;
            }else {
                digits[i] = add;
                return digits;
            }
        }
        //假如到这里还没return
        result[0] = 1;
        for (int i = 1;i<length+1;i++){
            result[i] = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(plusOne(new int[]{ 9}));
    }
}
