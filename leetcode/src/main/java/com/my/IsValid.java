package com.my;

import java.util.Stack;

/**
 * 有效的括号
 * @author shanghang
 */
public class IsValid {
    /**
     * 栈
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if("".equals(s) || s.length()<=0){
            return true;
        }
        if(s.length() % 2 !=0 ){
            //长度不是奇数
            return false;
        }
        boolean result = false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ;i<s.length();i++){
            char temp = s.charAt(i);
            if (temp == '(' || temp == '[' || temp == '{') {
                //遇到左括号入栈
                stack.push(temp);
            }else {
                //遇到右括号出栈并且判断是否符合
                if(stack.isEmpty() || !judge(stack.pop(),temp)){
                    //栈为空或者不存在
                    return false;
                }else {
                    result = true;
                }
            }
        }
        if(!stack.isEmpty()){
            //需要左括号都出栈
            return false;
        }
        return result;
    }

    public static boolean judge(char a, char b){
        if(a == '{'){
            if(b == '}'){
                return true;
            }else {
                return false;
            }
        }else if(a=='['){
            if(b == ']'){
                return true;
            }else {
                return false;
            }
        }else {
            if (b == ')'){
                return true;
            }else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("(()("));
    }
}
