package com.my;

import java.util.HashMap;

/**
 * 最长回文子串
 * @author shang
 */
public class LongestPalindrome {
    /**
     * 暴力法超时
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if(s.length() == 1 || isPalindrome(s)){
            return s;
        }
        String result = "";
        HashMap<String,Integer> key = new HashMap<String, Integer>(8);
        for (int i = 0 ; i<s.length() ; i++){
            for (int j = i+1;j<=s.length();j++){
                String temp = s.substring(i,j);
                if(isPalindrome(temp)){
                    if(result.length()<temp.length()){
                        result = temp;
                    }
                }
            }
        }
        return result;
    }
    public static String longestPalindrome1(String s) {
        if(s.length() == 1 || isPalindrome(s)){
            return s;
        }
        String result = "";
        HashMap<String,Integer> key = new HashMap<String, Integer>(8);
        for (int begin = 0 ,end = 0 ; end<=s.length();end++){
            String temp = s.substring(begin,end);
            if(isPalindrome(temp)){
                if(temp.length()>result.length()){
                    result = temp;
                }
            }else{
                if(result.length()>begin){
                    begin = result.length();
                }
            }
        }
        return result;
    }

        public static boolean isPalindrome(String s){
        int k = 2;
        int count = s.length();
        for (int i=0 ;i<count/k;i++){
            if(s.charAt(i) != s.charAt(count-i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aba"));
    }
}
