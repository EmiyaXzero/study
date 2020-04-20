package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/20 22:19
 **/
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        if(s.length()<=1){
            return s;
        }
        int real = n%s.length();
        if(real>0){
            return s.substring(real)+s.substring(0,real-1);
        }else {
            return s;
        }
    }
}
