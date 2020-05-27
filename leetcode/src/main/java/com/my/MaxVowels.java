package com.my;

import java.util.HashMap;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5417. 定长子串中元音的最大数目
 * @Date: 2020/5/24 11:02
 **/
public class MaxVowels {

    public int maxVowels(String s, int k) {
        int result = 0;
        int cur = 0;
        int left = 0 ,right = 0;
        while (right<s.length()){
            if (s.charAt(right) == 'a' || s.charAt(right) == 'e' || s.charAt(right) == 'i' ||s.charAt(right) == 'o'||s.charAt(right) == 'u'){
                cur++;
            }
            if (right-left+1 == k){
                if(cur>result){
                    result = cur;
                }
                if(s.charAt(left) == 'a' || s.charAt(left) == 'e' || s.charAt(left) == 'i' ||s.charAt(left) == 'o'||s.charAt(left) == 'u'){
                    cur--;
                }
                left++;
            }
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        MaxVowels maxVowels = new MaxVowels();
        maxVowels.maxVowels("abciiidef",3);
    }
}
