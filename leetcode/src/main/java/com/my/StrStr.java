package com.my;

/**
 * 实现 strStr()
 * @author shanghang
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        int x = haystack.length(),y=needle.length();
        if(x<y){
            return -1;
        }
        if (y == 0 || haystack.equals(needle)){
            return 0;
        }
        for (int i =0;i<x-y+1;i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(haystack.substring(i,i+y).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * kmp算法
     * 在出错时，利用原有的匹配信息，尽量减少重新匹配的次数。
     * @param args
     */
    public static void main(String[] args) {

    }
}
