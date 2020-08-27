package com.my;

/**
 * @author shanghang
 * @title: RangeBitwiseAnd
 * @projectName study
 * @description: 201. 数字范围按位与
 * @date 2020/8/23-12:48
 */
public class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int m, int n) {
        /**
        * int res = m;
        * for(int i = m ;i<=n;i++){
        *     res&=i;
        * }
        * return res;
        ***/
        int i = 0;
        while(m!=n){
            //m,n都右移
            m>>=1;
            n>>=1;
            i++;
        }
        m<<=i;
        return m;
    }
}
