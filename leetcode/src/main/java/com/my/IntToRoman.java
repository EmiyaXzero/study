package com.my;

import java.util.HashMap;
import java.util.Map;

/**
 * 整数转罗马数字
 *
 * @author shang
 */
public class IntToRoman {
    static Map<Integer, String> roman = new HashMap<Integer, String>(8) {
        {
            put(1, "I");
            put(4, "IV");
            put(5, "V");
            put(9, "IX");
            put(10, "X");
            put(40, "XL");
            put(50, "L");
            put(90, "XC");
            put(100, "C");
            put(400, "CD");
            put(500, "D");
            put(900, "CM");
            put(1000, "M");
        }
    };

    static Map<Integer, String> romanX = new HashMap<Integer, String>(8) {
        {
            put(1, "I");
            put(2, "X");
            put(3, "C");
            put(4, "M");
        }
    };

    public static String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        if (roman.containsKey(num)) {
            return roman.get(num);
        }
        int n = 1, t=1;
        while (num > 0) {
            int k = num % 10 ;
            if(k == 1 || k == 4 || k ==9){
                sb.insert(0, roman.get(k*t));
            }else if(k>=5){
                for (int i =0 ; i<k-5;i++){
                    sb.insert(0,romanX.get(n));
                }
                sb.insert(0, roman.get(5*t));
            }else{
                for (int i =0 ; i<k;i++){
                    sb.insert(0,romanX.get(n));
                }
            }
            n++;
            num/=10;
            t*=10;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3999));
    }
    /**
     *因为罗马数不存在4000不存在 xM,从大到小
     **/
    public String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();
        int[] keys = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] values = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        while (num > 0) {
            for (int i = keys.length - 1; i >= 0; i--) {
                if (num >= keys[i]) {
                    num -= keys[i];
                    sb.append(values[i]);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
