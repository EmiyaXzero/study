package com.my;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {
    /**
     * 593 ms	40.1 MB  hashMap
     * 505 ms	161.7 MB hashSet
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int maxCount = 0;
        //将HashMap改成Set因为不需要保存value值,但是hashMap改成HashSet内存多了120M
        Set<String> map = new HashSet<>();
        if(null == s || "".equals(s) || s.length() <=0){
            return 0;
        }
        if(s.length() ==1){
            return 1;
        }
        char[] chars = new char[s.length()];
        s.getChars(0,s.length(),chars,0);
        //截取string字符串如果字符串不存在则塞到map里面
        boolean isEnd = false;
        for (int i = 0;i<chars.length;i++){
            String temp = new String();
            temp += chars[i];
            for (int j = i+1 ;j <chars.length ;j++){
                if(temp.contains(String.valueOf(chars[j]))){
                    map.add(temp);
                    if(maxCount < temp.length()){
                        maxCount = temp.length();
                    }
                    break;
                }else {
                    temp +=chars[j];
                    map.add(temp);
                    if(maxCount < temp.length()){
                        maxCount = temp.length();
                    }
                    if(maxCount == s.length()){
                        isEnd = true;
                        return  maxCount;
                    }
                }
            }
        }
        return maxCount;
    }

    /**
     * Leetcode官方答案
     * @param
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 无重复字符的最长子串
     * 取出字符串中无重复的最长子串的长度
     * 1.从头遍历字符串，将字符串当前字符塞到Map中的key，当前字符串下一个值放到value（如果重复出现value值会被替换成为下一个）
     * 2.假如当前值在map中存在则说明字符重复，只需要走到当前字符重复的时候（如果start比当前重复时候长度大说明回到子串就直接跳到）
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
       int maxInt = 0;
       int n = s.length();
       HashMap<Character,Integer> characters = new HashMap<>();
       for(int start =0 ,end = 0; end < n ;end++){
           char tempChar = s.charAt(end);
           if(characters.containsKey(tempChar)){
               //当字符存在的时候
               start = Math.max(characters.get(tempChar),start);
           }
           //每次计算当前的maxInt与当前字段大小
           maxInt = Math.max(end-start+1,maxInt);
           characters.put(tempChar,end+1);
       }
       return maxInt;
    }

        public static void main(String[] args) {
        System.out.printf(""+ lengthOfLongestSubstring3("abcdefagh"));
    }
}
