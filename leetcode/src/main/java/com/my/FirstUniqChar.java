package com.my;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author shang
 * @title: FirstUniqChar
 * @projectName study
 * @description: 字符串中的第一个唯一字符
 * @date 2020/1/30-13:12
 */
public class FirstUniqChar {
    /**
     *来个暴力法
     */
    public int firstUniqChar(String s) {
        HashSet<Character> ss = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(ss.contains(s.charAt(i))){
                continue;
            }else {
                ss.add(s.charAt(i));
            }
            boolean isDouble = false;
            for (int j = i+1;j<s.length();j++){
                if(s.charAt(j) == s.charAt(i)){
                    isDouble = true;
                    break;
                }
            }
            if(!isDouble){
                return i;
            }
        }
        return -1;
    }
    /**
     * 遍历两次字符串,stm这个比上面还慢
     */
    public int firstUniqChar2(String s) {
        HashMap<Character,Integer> ss = new HashMap<>(32);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ss.put(c, ss.getOrDefault(c, 0) + 1);
        }

        for (int i=0 ;i<s.length();i++){
            if(ss.get(s.charAt(i) ) == 1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 用int数组应该最快
     */
    public int firstUniqChar3(String s) {
        int[] ss = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ss[c-'a'] ++;
        }

        for (int i=0 ;i<s.length();i++){
            if(ss[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
