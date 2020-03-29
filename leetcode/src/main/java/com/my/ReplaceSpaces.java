package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/3/29 20:49
 **/
public class ReplaceSpaces {
    public String replaceSpaces(String S, int length) {
        char[] temp = new char[3*length];
        int j = 0;
        for (int i = 0; i < length; i++) {
            if(S.charAt(i)==' '){
                //为空格
                temp[j++] = '%';
                temp[j++] = '2';
                temp[j++] = '0';
            }else{
                temp[j++] = S.charAt(i);
            }
        }
        return new String(temp).substring(0,j);
    }

    public static void main(String[] args) {
        ReplaceSpaces r = new ReplaceSpaces();
        r.replaceSpaces("Mr John Smith    ", 13);
    }
}
