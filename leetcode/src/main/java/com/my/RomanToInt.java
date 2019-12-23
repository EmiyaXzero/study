package com.my;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 * @author shanghang
 */
public class RomanToInt {
    static Map<String,Integer> roman = new HashMap<String,Integer>(8){
        {
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
        }
    };

    public static int romanToInt(String s) {
        int result = 0;
        if(s.length() == 1){
            return roman.get(s.substring(0,1));
        }
        //如果左边数字比右边小则两个数字整体为 右边减左边
        int i = 0;
        while (i<s.length()){
            if((i+1)<s.length()){
                if(judge(s.substring(i,i+1),s.substring(i+1,i+2))){
                    result+=roman.get(s.substring(i,i+1));
                    i++;
                }else {
                    result+=roman.get(s.substring(i+1,i+2)) - roman.get(s.substring(i,i+1));
                    i+=2;
                }
            }else{
                result+=roman.get(s.substring(i,i+1));
                i++;
            }
        }
        return result;
    }

    public static boolean judge(String a, String b){
        return roman.get(a)>=roman.get(b);
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("D"));
    }
}
