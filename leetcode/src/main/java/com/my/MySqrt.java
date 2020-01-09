package com.my;

/**
 * @author shang
 * @title: MySqrt
 * @projectName study
 * @description: x 的平方根
 * @date 2020/1/9-10:38
 */
public class MySqrt {
    /**
     * 相乘会int越界
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        int left = 0 ,right = x/2;
        if(x<4){
            right=x;
        }
        if(x>=46340){
            right = 46340;
        }
        while (left<right){
            int mid = left+(right-left)/2;
            if(mid*mid == x || (mid*mid<x && (mid+1)*(mid+1)>x)){
                return mid;
            }else if(mid*mid>x&&(mid-1)*(mid-1)<x){
                return mid-1;
            }else if(mid*mid <x){
                left=mid+1;
            }else if(mid*mid>x){
                right = mid-1;
            }
        }
        return left;
    }

    /**
     * 相乘会int越界,改成long试试
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {
        if(x==0){
            return 0;
        }
        long left = 1 ,right = x/2;
        while (left<right){
            long mid = left+(right-left)/2;
            if(mid*mid == x || (mid*mid<x && (mid+1)*(mid+1)>x)){
                return (int)mid;
            }else if(mid*mid>x&&(mid-1)*(mid-1)<x){
                return (int) mid-1;
            }else if(mid*mid <x){
                left=mid+1;
            }else if(mid*mid>x){
                right = mid-1;
            }
        }
        return  (int)left;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt2(183692038));
    }
}
