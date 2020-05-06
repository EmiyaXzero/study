package com.my;

/**
 * @author shang
 * @title: GcdOfStrings
 * @projectName study
 * @description: 1071. 字符串的最大公因子
 * @date 2020/5/6-16:55
 */
public class GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if(str1.length()<str2.length()){
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        int len1 = str1.length();
        int len2 = str2.length();
        StringBuffer sb = new StringBuffer();
        String result ="";
        for (int i = 0 ;i<str2.length();i++){
            if(str2.charAt(i) == str1.charAt(i)){
                sb.append(str2.charAt(i));
                if((len1%(i+1)==0) && (len2%(i+1)==0) && str1.split(sb.toString()).length== 0 && str2.split(sb.toString()).length == 0){
                    result = sb.toString();
                }
            }else {
                break;
            }
        }
        return result;
    }
    public String gcdOfStringsBy2(String str1, String str2) {
        //若 str1 = m*singleChar  str2 = n*singleChar那么结果就是两字符串最大公约数
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        // 辗转相除法求最大公约数。
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        return b == 0?a:gcd(b,a%b);
    }

    public static void main(String[] args) {
        GcdOfStrings gcdOfStrings = new GcdOfStrings();
        gcdOfStrings.gcdOfStrings("ABCABC","ABC");
    }
}
