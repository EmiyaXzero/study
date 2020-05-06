package com.my;

/**
 * @author shang
 * @title: Multiply
 * @projectName study
 * @description: 字符串相乘
 * @date 2020/4/30-9:23
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        //num1长度比num2大，乘法最后转化为加法
        if(num1.length()>num2.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        String[] sbs = new String[num1.length()];
        int zeroCount = 0;
        for (int j = num2.length()-1;j>=0;j--){
            StringBuffer result = new StringBuffer();
            for (int i = 0;i<zeroCount;i++){
                result.insert(0,0);
            }
            getAdd(num1,num2.charAt(j),result);
            sbs[j] = result.toString();
            zeroCount++;
        }
        String last = sbs[0];
        for (int i = 1 ;i<sbs.length;i++){
            StringBuffer ssb = new StringBuffer();
            String tempS = sbs[i];
            addTwoString(tempS,last,ssb);
            last = ssb.toString();
        }
        return last;

    }

    public void getAdd(String num1 ,char b,StringBuffer result){
        int jin = 0;
        for (int i =num1.length()-1;i>=0;i--){
           int temp =  (num1.charAt(i)-'0')*(b-'0') + jin;
           jin = temp/10;
           result.insert(0,temp%10);
        }
        if(jin>0){
            result.insert(0,jin);
        }
    }

    public void addTwoString(String last , String tempS , StringBuffer sb){
        if(last.length() > tempS.length()){
            String temp = last;
            last = tempS;
            tempS = temp;
        }
        int jin = 0;
        for (int i = 0;i<last.length();i++){
            int temp = last.charAt(last.length()-1-i)-'0' + tempS.charAt(tempS.length()-1-i)-'0'+jin;
            sb.insert(0,temp%10);
            jin = temp/10;
        }
        for (int i = tempS.length()-last.length()-1;i>=0;i--){
            int temp = tempS.charAt(i)-'0'+jin;
            sb.insert(0,temp%10);
            jin = temp/10;
        }
        if(jin>0){
            sb.insert(0,jin);
        }
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        multiply.multiply("98","9");
    }
}
