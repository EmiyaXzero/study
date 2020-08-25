package com.my;

/**
 * @author shanghang
 * @title: RepeatedSubstringPattern
 * @projectName study
 * @description: 459. 重复的子字符串
 * @date 2020/8/24-9:12
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        for(int i = 1 ;i<=s.length()/2;i++){
            String s1 = s.substring(0,i);
            String s2 = s.substring(i,s.length());
            if(s.equals(s2+s1)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new RepeatedSubstringPattern().repeatedSubstringPattern("abab");
    }

    public boolean repeatedSubstringPattern2(String s) {
       return (s+s).indexOf(s,1) != s.length();
    }
}
