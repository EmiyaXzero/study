package com.my;

/**
 * 和为零的N个唯一整数
 * @author shang
 */
public class SumZero {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        if(n%2 == 0 ){
            //偶数
            for (int i = 0 ;i < n/2 ; i++){
                result[2*i] = i+1;
                result[2*i+1] = -i-1;
            }
        }else{
            for (int i = 0 ;i < n/2 ; i++){
                result[2*i] = i+1;
                result[2*i+1] = -i-1;
            }
            result[n-1]=0;
        }
        return result;
    }
}
