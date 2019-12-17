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

    /**
     * 动态规划法，回文字符串里面也是回文字符串，i,j两个下标遍历字符串，
     * 如果i,j两个下标相等则i回到最初，j+1如果i,j字符相等且领近则是回文，如果i j 相等但不临近则判断中间是否是回文串
     * @param s
     * @return
     */
        public static String longestPalindrome2(String s) {
            String result = "";
            if(s.length() == 1 || isPalindrome(s)){
                return s;
            }
            int i = 0,j = 0;
            while(j<s.length()){
                if(i == j){
                    //本身也是个回文字符串
                    String tempStr = s.substring(i,j+1);
                    if(result.length() < tempStr.length()){
                        result = tempStr;
                    }
                    i = 0;
                    j++;
                    continue;
                }
                if(s.charAt(i) == s.charAt(j)){
                    String tempStr = s.substring(i,j+1);
                    //如果i,j字符相等且领近
                    if((j-i)==1){
                        if(result.length() < tempStr.length()){
                            result = tempStr;
                        }
                    }else{
                        //如果i j 相等但不临近则判断中间是否是回文串
                        String tempStr2 = s.substring(i+1,j);
                        if(isPalindrome(tempStr2)){
                            if(result.length() < tempStr.length()){
                                result = tempStr;
                            }
                        }
                    }
                }
                i++;
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
        System.out.println(longestPalindrome2("aba"));
    }
}
