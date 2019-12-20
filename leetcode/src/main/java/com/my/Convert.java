package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * Z 字形变换
 * @author shanghang
 */
public class Convert {
    /**
     * 竖有numRows个横numRows-2
     * 执行用时 :
     * 17 ms
     * , 在所有 java 提交中击败了
     * 39.28%
     * 的用户
     * 内存消耗 :
     * 39.5 MB
     * , 在所有 java 提交中击败了
     * 91.67%
     * 的用户
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if(numRows == 1 || (s.length() ==numRows)){
            return s;
        }
        //把string换成stringBuffer少了7毫秒
        StringBuffer result =new StringBuffer();
        StringBuffer[] strList = new StringBuffer[numRows];
        for(int i = 0; i <numRows ;i++){
            //初始化List
            strList[i] = new StringBuffer();
        }
        int vertical = 0;
        int horizontal = 0;
        int k = 0;
        boolean isVer = true;
        boolean isHor = false;
        while(k<s.length()){
            //先竖向，再横向
            if(isVer || numRows==2){
                //0，1，2，3
                strList[vertical].append(s.charAt(k));
                vertical ++;
                k++;
                if(vertical>numRows-1){
                    vertical = 0;
                    isVer = false;
                    isHor = true;
                }
                continue;
            }
            if(isHor && numRows!=2){
                //横走的时候是倒过来的，2，1
                strList[numRows-horizontal-2].append(s.charAt(k));
                horizontal++;
                k++;
                if(horizontal>(numRows-3)){
                    horizontal = 0;
                    isVer = true;
                    isHor = false;
                }
                continue;
            }
        }
        for(int i = 0; i <numRows ;i++){
            result.append(strList[i]);
        }
        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers." , 4));
    }
}
