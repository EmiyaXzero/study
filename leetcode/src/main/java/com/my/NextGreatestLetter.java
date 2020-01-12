package com.my;

import java.util.HashSet;

/**
 * 寻找比目标字母大的最小字母
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/1/12 11:18
 **/
public class NextGreatestLetter {
    public static char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i <letters.length ; i++) {
            if(letters[i]==target){
                if(i+1 == letters.length){
                    return letters[0];
                }else {
                    return letters[i+1];
                }
            }else if(letters[i]>target){
                return letters[i];
            }
        }
        return 'a';
    }


    public static void main(String[] args) {
        nextGreatestLetter(new char[]{'c','f','j','a','b'},'z');
    }

    public char  isBig(char[] letters, char target){
        boolean isfirst = true;
        for (int i = 0; i <letters.length ; i++) {
            if(isfirst && letters[i] != letters[0]){
                isfirst = false;
            }
            if(letters[i]>target){
                return letters[i];
            }
            if(!isfirst && letters[i] == letters[0]){
                return letters[0];
            }

        }
        return letters[0];
    }

}
