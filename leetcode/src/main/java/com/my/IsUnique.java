package com.my;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/3/28 20:49
 **/
public class IsUnique {
    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<Character>();
        for(int i = 0 ;i<astr.length() ;i++){
            if(set.contains(astr.charAt(i))){
                return false;
            }else {
                set.add(astr.charAt(i));
            }
        }
        return true;
    }
}
