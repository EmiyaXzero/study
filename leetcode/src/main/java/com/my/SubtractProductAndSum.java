package com.my;

/**
 * 整数的各位积和之差
 * @author shang
 */
public class SubtractProductAndSum {
    public int subtractProductAndSum(int n) {
        if ( 1<=n && n<= 9){
            return 0;
        }
        int add = 0;
        int x = 1;
        while (n != 0 ){
            int last = n%10;
            add +=last;
            x *=last;
            n=n/10;
        }
        return  x-add;
    }
}
