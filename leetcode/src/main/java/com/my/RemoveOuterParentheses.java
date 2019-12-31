package com.my;

import java.util.Stack;

/**
 * 删除最外层的括号
 * @author shang
 */
public class RemoveOuterParentheses {
    public static String removeOuterParentheses(String S) {
        StringBuffer sb = new StringBuffer();
        Stack stack = new Stack();
        //第一个左括号入库
        for (int i = 0 ;i<S.length();i++){
            if('(' == S.charAt(i)){
                //入栈的时候栈长度大于1
                stack.add(S.charAt(i));
                if(stack.size()>1){
                    sb.append(S.charAt(i));
                }
            }else{
                //出栈的时候栈长度大于1
                stack.pop();
                if(stack.size()>0){
                    sb.append(S.charAt(i));
                }
            }

        }
        return sb.toString();
    }
    public static String removeOuterParentheses2(String S) {
        StringBuffer sb = new StringBuffer();
        //用k计数会更快，入栈出栈比较慢
        int k = 0;
        //第一个左括号入库
        for (int i = 0 ;i<S.length();i++){
            if('(' == S.charAt(i)){
                //入栈的时候栈长度大于1
                k++;
                if(k>1){
                    sb.append(S.charAt(i));
                }
            }else{
                //出栈的时候栈长度大于1
                k--;
                if(k>0){
                    sb.append(S.charAt(i));
                }
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses2("(()())(())"));
    }
}
