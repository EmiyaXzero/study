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


}
