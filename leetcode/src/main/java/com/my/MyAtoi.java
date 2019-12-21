package com.my;

/**
 * 字符串转换整数 (atoi)
 * @author shanghang
 */
public class MyAtoi {
    /**
     * 执行用时 :
     * 2 ms
     * , 在所有 java 提交中击败了
     * 99.58%
     * 的用户
     * 内存消耗 :
     * 35.6 MB
     * , 在所有 java 提交中击败了
     * 89.66%
     * 的用户
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        int result = 0;
        int j = 0;
        //不用trim看看能不能快,事实证明并不能
        //String newStr = str.trim();
        if("".equals(str) || str.length() <=0){
            return 0;
        }
        while(j<str.length() && str.charAt(j) == ' ' ){
            j++;
        }
        if(j>=str.length()){
            return 0;
        }
        if(str.charAt(j)!='-' && !(str.charAt(j) >='0' && str.charAt(0)<='9') && str.charAt(j)!='+'){
            return 0;
        }
        int k = 1;
        if(str.charAt(j) == '-'){
            k=-1;
            j++;
        }else if(str.charAt(j) == '+'){
            j++;
        }

        while (j<str.length()){
            if(!(str.charAt(j) >='0' && str.charAt(j)<='9')){
                return result;
            }else{
                //果然快了1毫秒
                //int pop = Integer.parseInt(str.charAt(j)+"");
                int pop = str.charAt(j) -'0';
                if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10  && pop > 7)){
                    return Integer.MAX_VALUE;
                }
                if(result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10  && pop > 8)){
                    return Integer.MIN_VALUE;
                }
                    result *= 10;
                    result +=pop*k;
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi(" "));
    }
}
