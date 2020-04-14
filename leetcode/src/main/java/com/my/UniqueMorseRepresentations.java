package com.my;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/14 22:50
 **/
public class UniqueMorseRepresentations {
    public String[] moSi = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> wordSet = new HashSet<>();
        int count = 0;
        for (int i = 0;i<words.length;i++){
            StringBuffer s = new StringBuffer();
            for (int j = 0 ;j<words[i].length() ;j++){
                s.append(moSi[words[i].charAt(j)-'a']);
            }
            String result = s.toString();
            if(!wordSet.contains(result)){
                wordSet.add(result);
                count++;
            }
        }
        return count;
    }
}
