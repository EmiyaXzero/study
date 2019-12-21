package com.my;

/**
 * 整数反转
 * @author shanghang
 */
public class Reverse {
    /**
     * INT-MAX:2147483647 INT-MIN  -2147483648
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int result = 0;
        int pop;
        while(x !=0){
            //最后一位数
            pop = x%10;
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10  && pop > 7)){
                return 0;
            }
            if(result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10  && pop > 8)){
                return 0;
            }
            //放在上面会溢出
            result *=10;
            result +=pop;
            x = x/10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
