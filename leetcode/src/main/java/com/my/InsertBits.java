package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/10 0:08
 **/
public class InsertBits {
    public int insertBits(int N, int M, int i, int j) {
        int ans =0 ,bit;
        //m左移i位
        M<<=i;
        for (int k =0 ;k< 32;k++){
            if(k>=i && k<=j){
                //取M在k位的值1左移到K位左右都是0
                bit = M&(1<<k);
            }else{
                bit = N&(1<<k);
            }
            ans+=bit;
        }
        return ans;
    }
}
