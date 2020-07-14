package com.my;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shanghang
 * @title: Respace
 * @projectName study
 * @description: 面试题 17.13. 恢复空格
 * @date 2020/7/9-19:47
 */
public class Respace {
    public int respace(String[] dictionary, String sentence) {
        Set<String> sets = new HashSet<>();
        for (String temp: dictionary){
            sets.add(temp);
        }
        int len = sentence.length();
        int[] dp = new int[len+1];
        for (int i = 1;i<=len;i++){
            dp[i] = dp[i-1]+1;
            for (int j = 0 ;j<i;j++){
                if(sets.contains(sentence.substring(j,i))){
                    dp[i] = Math.min(dp[i],dp[j]);
                }
            }
        }
        return dp[len];
    }
}
