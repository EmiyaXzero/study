package com.my;

/**
 * @author shanghang
 * @title: IsSubsequence
 * @projectName study
 * @description: 392. 判断子序列
 * @date 2020/7/27-17:26
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length()){
            return false;
        }
        int left = 0 ,right = 0;
        while (left < s.length() && right<t.length()){
            if(s.charAt(left) == t.charAt(right)){
                left++;
            }
            right++;
        }
        return s.length() == left;
    }
}
