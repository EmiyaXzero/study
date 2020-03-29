package com.my;

import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/3/29 20:58
 **/
public class CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        //偶数
        for (int i = 0 ; i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),(map.get(s.charAt(i))+1));
            }else {
                map.put(s.charAt(i),1);
            }
        }
        Iterator iterator = map.keySet().iterator();
        if((s.length() & 1) == 0){
            if(iterator.hasNext()){
                if((map.get(iterator.next()) & 1) == 1){
                    return false;
                }
            }
        }else {
            //奇数
            int count = 0;
            while(iterator.hasNext()){
                if((map.get(iterator.next()) & 1) == 1){
                    count ++;
                    if(count == 2){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanPermutePalindrome canPermutePalindrome = new CanPermutePalindrome();
        System.out.println(canPermutePalindrome.canPermutePalindrome("abc"));
    }
}
