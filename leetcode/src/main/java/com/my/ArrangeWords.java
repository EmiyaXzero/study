package com.my;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5413. 重新排列句子中的单词
 * @Date: 2020/5/17 10:34
 **/
public class ArrangeWords {

    public String arrangeWords(String text) {
        text = text.toLowerCase();
        String[] ss = text.split(" ");
        Arrays.sort(ss, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        StringBuffer sb = new StringBuffer();
        String s1 = ss[0];
        char upChar = Character.toUpperCase(s1.charAt(0));
        sb.append(upChar);
        for (int i = 1;i<s1.length();i++){
            sb.append(s1.charAt(i));
        }
        sb.append(" ");
        for (int i = 1 ;i<ss.length;i++){
            sb.append(ss[i]);
            if(i!=ss.length-1){
                sb.append(" ");
            }
        }
      return   sb.toString();
    }

    public static void main(String[] args) {
        ArrangeWords arrangeWords = new ArrangeWords();
        arrangeWords.arrangeWords("Leetcode is cool");
    }
}
