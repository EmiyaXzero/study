package com.my;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: shanghang
 * @Project:study
 * @Descrip:判定是否互为字符重排
 * @Date: 2020/3/28 20:53
 **/
public class CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i <c1.length ; i++) {
            if(c1[i] != c2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckPermutation c = new CheckPermutation();
        c.CheckPermutation("abc",
                "bca");
    }
}
