package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * @author shanghang
 */
public class GenerateParenthesis {

    /**
     * 右括号的个数小于左括号就能加右括号
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result,"" ,0,0,n);
        return result;
    }

    public static void generate(List<String> result ,String str ,int left ,int right ,int n){
        if(str.length() == n*2){
            result.add(str);
            return;
        }
        if(left< n){
            //加左括号,但是左括号不能多于n
            generate(result,str+"(",left+1,right,n);
        }
        if(left>right) {
            //加右括号,只有左括号多于右括号才能添加
            generate(result,str+")",left,right+1,n);
        }
    }












    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        String s = "";
        generate1(result,s,n,0,0);
        return result;
    }

    public void generate1(List<String> result , String s ,int n ,int left ,int right){
        if(s.length() == 2*n){
            result.add(s);
            return;
        }
        if(left<n) {
            generate1(result, s + "(", n, left + 1, right);
        }
        if(left>right){
            generate1(result,s+")",n,left,right+1);
        }

    }






}
