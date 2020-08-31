package com.my;

import java.util.Stack;

/**
 * 翻转字符串里的单词
 * @author shang
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        if (null == s || s.equals("") || s.length() <= 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        String[] splits = s.split(" ");
        for (int i = splits.length - 1; i >= 0; i--) {
            if (splits[i].equals(" ") || splits[i].equals("")) {
                continue;
            } else {
                sb.append(splits[i]);
                sb.append(" ");
            }
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWordsIII3("Let's take LeetCode contest"));
    }

    /**
     * 用栈非空格进，空格出。效率不快。
     * 反转字符串中的单词 III
     */
    public static String reverseWordsIII(String s) {
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        while (i <= chars.length) {
            if (i == chars.length || chars[i] == ' ') {
                //stack出栈
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                if (i != chars.length) {
                    sb.append(chars[i]);
                }
            } else {
                stack.add(chars[i]);
            }
            i++;
        }
        return sb.toString();
    }

    /**
     * 不用栈
     * @param s
     * @return
     */
    public static String reverseWordsIII2(String s) {
        if (null == s || s.equals("") || s.length() <= 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        String[] ss = s.split(" ");
        for (String s1 : ss) {
            for (int i = s1.length()-1; i >=0; i--) {
                sb.append(s1.charAt(i));
            }
            sb.append(" ");
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    /**
     * 反转字符数组
     * @param s
     * @return
     */
    public static String reverseWordsIII3(String s) {
        char[] result = s.toCharArray();
        int i = 0;
        int end ;
        while(i<result.length) {
            end = s.indexOf(' ',i+1);
            if(end <0){
                end = result.length;
            }
            reverseInner(result,i,end-1);
            i= end+1;
        }
        return String.copyValueOf(result);
    }

    public static void reverseInner(char[] chars, int begin, int end){
        char temp ;
        while (begin<end){
            temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }
    }

}
