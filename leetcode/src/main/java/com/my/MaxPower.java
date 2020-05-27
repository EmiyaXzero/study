package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5396. 连续字符
 * @Date: 2020/5/16 22:32
 **/
public class MaxPower {

    public int maxPower(String s) {
        int max = 1;
        int length = 1;
        char sChar = s.charAt(0);
        for (int i = 1;i<s.length();i++){
            if(sChar == s.charAt(i)){
                length++;
            }else {
                sChar = s.charAt(i);
                length = 1;
            }
            max = Math.max(max,length);
        }
        return max;
    }
}
