package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5416. 检查单词是否为句中其他单词的前缀
 * @Date: 2020/5/24 10:59
 **/
public class IsPrefixOfWord {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] ss = sentence.split(" ");
        for(int i = 0 ;i<ss.length;i++){
            if(ss[i].length()<searchWord.length()){
                continue;
            }
            if(ss[i].startsWith(searchWord)){
                return i;
            }

        }
        return -1;
    }
}
