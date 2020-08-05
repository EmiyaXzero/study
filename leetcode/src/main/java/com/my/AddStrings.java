package com.my;

/**
 * @author shanghang
 * @title: AddStrings
 * @projectName study
 * @description: 415. 字符串相加
 * @date 2020/8/3-9:20
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        if(num1.length() >num2.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        StringBuffer result = new StringBuffer();
        int sum = 0;
        for (int i = num1.length()-1,j = num2.length()-1 ;i>=0;i--,j--){
            char a = num1.charAt(i),b = num2.charAt(j);
            int addTemp = (a-'0')+(b-'0')+sum;
            result.append(addTemp%10);
            sum = addTemp/10;
        }
        for (int i = num2.length()-num1.length()-1;i>=0;i--){
            char a = num2.charAt(i);
            int addTemp = (a-'0')+sum;
            result.append(addTemp%10);
            sum = addTemp/10;
        }
        if(sum>0){
            result.append(sum);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        new AddStrings().addStrings("98","9");
    }
}
