package com.my;

/**
 * @author shanghang
 * @title: IsInterleave
 * @projectName study
 * @description: 97. 交错字符串
 * @date 2020/7/18-13:10
 */
public class IsInterleave {
    /**
     * 递归超时了2333333
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()){
            return false;
        }
        return doIt(s1,s2,s3,0);
    }

    public boolean doIt(String s1,String s2,String s3 , int idx){
        if(idx == s3.length()){
            return true;
        }
        if(s1 == null || s1.equals("")){
            return s3.charAt(idx) == s2.charAt(0) && doIt(s1,s2.substring(1),s3,idx+1);
        }else if(s2 == null || s2.equals("")){
            return s3.charAt(idx) == s1.charAt(0) && doIt(s1.substring(1),s2,s3,idx+1);
        }else if(s3.charAt(idx) == s1.charAt(0) && s3.charAt(idx) == s2.charAt(0)){
            return doIt(s1.substring(1),s2,s3,idx+1) || doIt(s1,s2.substring(1),s3,idx+1);
        }else if(s3.charAt(idx) == s1.charAt(0)){
            return doIt(s1.substring(1),s2,s3,idx+1);
        }else if(s3.charAt(idx) == s2.charAt(0)){
            return  doIt(s1,s2.substring(1),s3,idx+1);
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        IsInterleave isInterleave = new IsInterleave();
        isInterleave.isInterleave("a","","c");
    }

    /**
     * 动态规划
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave2(String s1, String s2, String s3) {
        boolean[][][] dp  = new boolean[s3.length()+1][s1.length()+1][s2.length()+1];
        if(s3.length() == 0){
            return true;
        }
        if(s1.length()+s2.length() != s3.length()){
            return false;
        }
        dp[0][0][0] = true;
        //i表示s3的长度，j表示s1的长度，i-j表示s2的长度
        for (int i = 1;i<=s3.length();i++){
            for (int j = 0;j<=i && j<=s1.length();j++){
                if(j<i && (i-j<=s2.length()) && s3.charAt(i-1) == s2.charAt(i-j-1) && !dp[i][j][i-j]){
                    dp[i][j][i-j] = dp[i-1][j][i-j-1];
                }
                if(j>0 && (i-j<=s2.length()) && s3.charAt(i-1) == s2.charAt(j-1) && !dp[i][j][i-j]){
                    dp[i][j][i-j] = dp[i-1][j-1][i-j];
                }
            }
        }
        return dp[s3.length()][s1.length()][s2.length()];
    }
}
