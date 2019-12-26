package com.my;

import java.util.HashSet;

/**
 * 宝石与石头
 * @author shang
 */
public class NumJewelsInStones {

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        HashSet<Character> jKey = new HashSet<>(8);
        for (int i = 0 ;i < J.length() ;i++){
            jKey.add(J.charAt(i));
        }
        for (int i = 0 ;i < S.length() ;i++){
            if(jKey.contains(S.charAt(i))){
                count++;
            }
        }
        return count;
    }
}
