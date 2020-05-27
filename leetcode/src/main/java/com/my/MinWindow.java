package com.my;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: shanghang
 * @Project:study
 * @description:76. 最小覆盖子串
 * @Date: 2020/5/23 22:56
 **/
public class MinWindow {
    public String minWindow(String s, String t) {
        boolean[] booleanT = new boolean[t.length()];
        int booleanLenght = 0;
        int result = Integer.MAX_VALUE;
        int i = 0 ,j = 0;
        int[] key = new int[2];
        while (i<s.length() && j<s.length()){
            for (;j<s.length();j++){
                for (int k = 0;k<t.length();k++){
                    if(booleanT[k]){
                        continue;
                    }
                    if(s.charAt(j) == t.charAt(k)){
                        booleanLenght++;
                        booleanT[k] = true;
                        break;
                    }
                }
                if(booleanLenght == t.length()){
                    int len = j-i;
                    if(len<result){
                        result = len;
                        key[0] = i;
                        key[1] = j;
                    }
                }
            }
            Arrays.fill(booleanT,false);
            booleanLenght = 0;
            i++;
            j=i;
        }
        if(result == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(key[0],key[1]+1);
    }

    /**
     * 滑动窗口先右滑然后左边找到最小
     * @param s
     * @param t
     * @return
     */
    /**
     * 记录t中字符有多少
     */
    Map<Character,Integer> ori = new HashMap<>();
    Map<Character,Integer> cnt = new HashMap<>();

    public String minWindowForMap(String s, String t) {
        int tLen = t.length();
        for (int i =0;i<tLen;i++){
            char c = t.charAt(i);
            ori.put(c,ori.getOrDefault(c,0)+1);
        }
        int left = 0 , right=0;
        int result = Integer.MAX_VALUE;
        int[] key = new int[2];
        while (right<s.length()){
            if(right<s.length() && ori.containsKey(s.charAt(right))){
                cnt.put(s.charAt(right),cnt.getOrDefault(s.charAt(right),0)+1);
            }
            while (check() && left<=right){
                if(right-left+1<result){
                    result = right-left+1;
                    key[0] = left;
                    key[1] = right +1;
                }
                if(cnt.containsKey(s.charAt(left))){
                    cnt.put(s.charAt(left),cnt.getOrDefault(s.charAt(left),0)-1);
                }
                left++;
            }
            right++;
        }
        return result == Integer.MAX_VALUE?"":s.substring(key[0],key[1]);
    }

    public boolean check(){
        Iterator oIterator = ori.keySet().iterator();
        while (oIterator.hasNext()){
            char key = (char) oIterator.next();
            if(!cnt.containsKey(key) || cnt.get(key)<ori.get(key)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        minWindow.minWindowForMap("ADOBECODEBANC","ABC");
    }

}
