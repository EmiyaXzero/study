package com.my;

import java.util.Arrays;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5386. 检查一个字符串是否可以打破另一个字符串
 * @Date: 2020/5/3 0:09
 **/
public class CheckIfCanBreak {
    public boolean checkIfCanBreak(String s1, String s2) {
        int length = s1.length();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if(chars1[0]>=chars2[length-1] || chars1[length-1]<=chars1[0]){
            return true;
        }
        int i = 0 ,j = 0;
        while (i<length && j<length){
            if(chars1[i]<=chars2[j]){
                i++;
            }
            j++;
        }
        boolean chars1ToChars2 = i==j;
        i = 0 ;
        j = 0;
        while (i<length && j<length){
            if(chars1[i]>=chars2[j]){
                j++;
            }
            i++;
        }
        return chars1ToChars2 || i==j;
    }

    public static void main(String[] args) {
        CheckIfCanBreak checkIfCanBreak = new CheckIfCanBreak();
        checkIfCanBreak.checkIfCanBreak("yopumzgd","pamntyya");
    }
}
