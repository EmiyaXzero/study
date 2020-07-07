package com.my;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: shanghang
 * @Project:study
 * @description:32. 最长有效括号
 * @Date: 2020/7/4 20:55
 **/
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int[] mark = new int[s.length()];
        //根据栈判断括号是不是有效的
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.add(i);
            }else if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    mark[i] = 1;
                }else {
                    stack.removeLast();
                }
            }
        }
        while (!stack.isEmpty()){
            int idx = stack.removeLast();
            mark[idx] = 1;
        }
        int max = 0;
        int len = 0;
        for (int i = 0;i<mark.length;i++){
            if(mark[i] == 1){
                len = 0;
                continue;
            }
            len++;
            max = Math.max(max,len);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        longestValidParentheses.longestValidParentheses(")()())");
    }
}
