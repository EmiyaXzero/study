package com.my;

/**
 * 有效的完全平方数
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/1/12 10:28
 **/
public class IsPerfectSquare {
    /**
     * int 范围-2^31——2^31-1  -2147483648~2147483647
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        boolean result = false;
        int left = 0 , right = 46340;
        if(num<4){
            right = 3;
        }else if(num<=right){
            right = num/2;
        }
        while (left<=right){
            int mid=left+(right-left)/2;
            if(mid*mid == num){
                result = true;
                break;
            }
            if(mid*mid>num){
                right = mid-1;
            }else {
                left=mid+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        isPerfectSquare(14);
    }
}
