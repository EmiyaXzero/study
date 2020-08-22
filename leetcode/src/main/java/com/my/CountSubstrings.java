package com.my;

/**
 * @author shanghang
 * @title: CountSubstrings
 * @projectName study
 * @description: 647. 回文子串
 * @date 2020/8/19-9:13
 */
public class CountSubstrings {
    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0;i<s.length();i++){
            for (int j = i;j<s.length();j++){
                if(isSub(s.substring(i,j+1))){
                    result++;
                }
            }
        }
        return result;
    }

    public boolean isSub(String s){
        int start = 0,end = s.length()-1;
        while (start<=end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }

    public int countSubstringsByDp(String s){
        int res = 0;
        int n = s.length();
        //dp[i][j]表示[i,j]的是否为回文串
        boolean[][] dp = new boolean[n][n];
        for (int i = n-1;i>=0;i--){
            for (int j = i;j<n;j++){
                if(s.charAt(i) == s.charAt(j) && (Math.abs(i-j)<=2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new CountSubstrings().countSubstrings("abc");
    }
}
