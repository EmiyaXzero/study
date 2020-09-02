package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @description:剑指 Offer 20. 表示数值的字符串
 * @Date: 2020/9/2 22:38
 **/
public class IsNumber {
    public boolean isNumber(String s) {
        try{
            Float.parseFloat(s);
        }catch(Exception e){
            return false;
        }
        if(s.indexOf("f")>0 || s.indexOf("F")>0 || s.indexOf("D")>0 || s.indexOf("d")>0){
            return false;
        }
        return true;
    }
}
