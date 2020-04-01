package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/3/31 23:03
 **/
public class IsFlipedString {
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        String ss=s2+s2;
        return ss.contains(s1);
    }
}
