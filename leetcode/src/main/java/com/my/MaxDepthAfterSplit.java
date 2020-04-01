package com.my;

import java.util.Stack;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/1 13:07
 **/
public class MaxDepthAfterSplit {
    /**
     * 不知道这道题考的啥
     * @param seq
     * @return
     */
    public int[] maxDepthAfterSplit(String seq) {
        //根据栈的深度
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[seq.length()];
        for (int i = 0; i <seq.length() ; i++) {
            if(seq.charAt(i) == '('){
                stack.add(i);
            }else {
                //右括号出栈
                int length = stack.size();
                result[i] = length%2;
                result[stack.pop()] = length%2;
            }
        }
        return result;
    }
}
