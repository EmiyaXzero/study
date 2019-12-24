package com.my;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 * @author shanghang
 */
public class RomanToInt {
    static Map<Character,Integer> roman = new HashMap<Character,Integer>(8){
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public static int romanToInt(String s) {
        int result = 0;
        if(s.length() == 1){
            return roman.get(s.charAt(0));
        }
        //如果左边数字比右边小则两个数字整体为 右边减左边
        int i = 0;
        while (i<s.length()){
            if((i+1)<s.length()){
                if(judge(s.charAt(i),s.charAt(i+1))){
                    result+=roman.get(s.charAt(i));
                    i++;
                }else {
                    result+=roman.get(s.charAt(i+1)) - roman.get(s.charAt(i));
                    i+=2;
                }
            }else{
                result+=roman.get(s.charAt(i));
                i++;
            }
        }
        return result;
    }

    public static boolean judge(char a, char b){
        return roman.get(a)>=roman.get(b);
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("D"));
    }
}
