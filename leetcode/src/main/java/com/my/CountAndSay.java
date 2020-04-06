package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/6 23:33
 **/
public class CountAndSay {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String s = countAndSay(n-1);
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ;i<s.length();i++){
            int count = 1;
            char a = s.charAt(i);
            while ( i+1<s.length() && s.charAt(i+1) == s.charAt(i) ){
                count++;
                i++;
            }
            sb.append(count+""+a);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay s = new CountAndSay();
        s.countAndSay(4);
    }
}
