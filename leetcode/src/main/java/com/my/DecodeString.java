package com.my;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shang
 * @title: DecodeString
 * @projectName study
 * @description: 394. 字符串解码
 * @date 2020/5/28-13:22
 */
public class DecodeString {
    public String decodeString(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ;i<s.length();i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                StringBuffer intS = new StringBuffer();
                while (i<s.length() && s.charAt(i)!='['){
                    intS.append(s.charAt(i));
                    i++;
                }
                i--;
               StringBuffer sb2 = new StringBuffer();
               int count = Integer.parseInt(intS.toString());
               String tempS = "";
               Deque<Character> characters = new ArrayDeque<>();
               for (int j =i+1;i<s.length();j++ ){
                    if(s.charAt(j)=='['){
                        characters.add(s.charAt(j));
                    }else if(s.charAt(j)==']'){
                        characters.removeLast();
                    }
                    if(characters.isEmpty()){
                        tempS = decodeString(s.substring(i+2,j));
                        i=j;
                        break;
                    }
               }
               for (int k=0;k<count;k++){
                   sb2.append(tempS);
               }
               sb.append(sb2);
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("100[leetcode]"));
    }
}
