package com.my;

/**
 * Pow(x, n)
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/1/11 16:20
 **/
public class MyPow {
    /**
     * 暴力法超时
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(x==0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        double result = x;
        if(n>0){
            for (int i=1 ;i<n;i++){
                result*=x;
            }
        }else {
            result = 1/x;
            for (int i=-1;i>n;i--){
                result/=x;
            }
        }
        return result;
    }

    /**
     * 递归还超时
     * x^4 = x^2*x^2
     */
    public static double myPow2(double x, int n) {
        if(x==0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        double dn = n;
        if(n<0){
            dn = -dn;
            x = 1/x;
        }
        return pow(x,dn);
    }

    private static double pow(double x, double n){
        if(n==0){
            return x;
        }else if(n==1){
            return x;
        }

        if(n%2==0){
            //偶数
            double half = pow(x,n/2);
            return half*half;
        }else {
            double half =pow(x,(n-1)/2);
            return half*half*x;
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow2(2.00000,
                10));
    }
}
