package com.my;

import java.util.HashMap;

/**
 * 最长回文子串
 *
 * @author shang
 */
public class LongestPalindrome {
    /**
     * 暴力法超时
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s.length() == 1 || isPalindrome(s)) {
            return s;
        }
        String result = "";
        HashMap<String, Integer> key = new HashMap<String, Integer>(8);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (isPalindrome(temp)) {
                    if (result.length() < temp.length()) {
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
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        String result = "";
        if (s.length() == 1 || isPalindrome(s)) {
            return s;
        }
        int i = 0, j = 0;
        while (j < s.length()) {
            if (i == j) {
                //本身也是个回文字符串
                String tempStr = s.substring(i, j + 1);
                if (result.length() < tempStr.length()) {
                    result = tempStr;
                }
                i = 0;
                j++;
                continue;
            }
            if (s.charAt(i) == s.charAt(j)) {
                String tempStr = s.substring(i, j + 1);
                //如果i,j字符相等且领近
                if ((j - i) == 1) {
                    if (result.length() < tempStr.length()) {
                        result = tempStr;
                    }
                } else {
                    //如果i j 相等但不临近则判断中间是否是回文串
                    String tempStr2 = s.substring(i + 1, j);
                    if (isPalindrome(tempStr2)) {
                        if (result.length() < tempStr.length()) {
                            result = tempStr;
                        }
                    }
                }
            }
            i++;
        }
        return result;
    }

    /**
     * 先来解释一下为什么中心是2n-1而不是n
     * 比如有字符串abcba，这时回文子串是abcba，中心是c；又有字符串adccda，这时回文子串是adccda，中心是cc。
     * 由此可见中心点既有可能是一个字符，也有可能是两个字符，
     * 当中心为一个字符的时候有n个中心，当中心为两个字符的时候有n-1个中心，所以一共有2n-1个中心。
     * 然后for循环开始从左到右遍历，为什么会有两次expandAroundCenter，
     * 一次是i和i本身，一次是i和i+1，这就是上面说到的一个中心与两个中心。
     * 而后会去判断这两种情况下谁的回文子串最长，并标记出这个子串在原字符串中的定位，即start和end。
     * BY LEETCODE  leopold
     *
     * @param s
     * @return
     */
    public static String longestPalindrome3(String s) {
        //增加两个过滤从223 ms到35ms
        if(null == s || s.length() <1){
            return "";
        }
        if(isPalindrome(s)){
            return s;
        }
        String result = "";
        for (int n = 0; n < s.length(); n++) {
            //奇数的情况下中间值就是本身
            String temp1 = getLongPalindrome(s, n, n);
            //偶数的情况下
            String temp2 = getLongPalindrome(s, n, n + 1);
            if (result.length() < temp1.length()) {
                result = temp1;
            }
            if (result.length() < temp2.length()) {
                result = temp2;
            }
        }
        return result;
    }

    public static String getLongPalindrome(String s, int low, int high) {
        String maxString = "";
        while (low >= 0 && high < s.length() && (s.charAt(low) == s.charAt(high))) {
            String tempStr = s.substring(low, high + 1);
            if (maxString.length() < tempStr.length()) {
                maxString = tempStr;
            }
            low--;
            high++;
        }
        return maxString;
    }

    /**
     * 不保存字符串直接保存下标
     * @param s
     * @return
     */
    public static String longestPalindrome4(String s) {
        if(s == null && s.length() < 1){
            return "";
        }
        //增加判断从8ms直接到5ms
        if(isPalindrome(s)){
            return s;
        }
        int start = 0 ,end = 0;
        for(int i = 0 ;i<s.length();i++){
            //奇数的情况
            int temp1 = getLongPalindrome2(s,i,i);
            int temp2 = getLongPalindrome2(s,i,i+1);
            int len = Math.max(temp1,temp2);
            if(len > (end - start)){
                //如果当前的节点的中点大于end-start,则更新end start
                end = i+len/2;
                start = i-(len-1)/2;
            }
        }
        return  s.substring(start,end+1);
    }
    public static int getLongPalindrome2(String s, int low, int high) {
        //取出最长的low和high
        while (low >= 0 && high < s.length() && (s.charAt(low) == s.charAt(high))) {
            low--;
            high++;
        }
        return high - low -1;
    }

    public static String longestPalindrome1(String s) {
        if (s.length() == 1 || isPalindrome(s)) {
            return s;
        }
        String result = "";
        HashMap<String, Integer> key = new HashMap<String, Integer>(8);
        for (int begin = 0, end = 0; end <= s.length(); end++) {
            String temp = s.substring(begin, end);
            if (isPalindrome(temp)) {
                if (temp.length() > result.length()) {
                    result = temp;
                }
            } else {
                if (result.length() > begin) {
                    begin = result.length();
                }
            }
        }
        return result;
    }

    public static boolean isPalindrome(String s) {
        int k = 2;
        int count = s.length();
        for (int i = 0; i < count / k; i++) {
            if (s.charAt(i) != s.charAt(count - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome4("cbbd"));
    }
}
