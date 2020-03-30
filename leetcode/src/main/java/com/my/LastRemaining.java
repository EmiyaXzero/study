package com.my;

import java.util.ArrayList;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/3/30 9:58
 **/
public class LastRemaining {
    public int lastRemaining2(int n, int m) {
        if(n==1){
            return 0;
        }else {
            ArrayList<Integer> temp = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                temp.add(i);
            }
            int j = 0;
            for(int i = n;i>1;i--){
                j=(j+m)%i-1;

                temp.remove(j);
            }
            return temp.get(0);
        }
    }

    public int lastRemaining(int n ,int m){
        if(n==1){
            return 0;
        }
        //获取n-1,删除的位置
        int x = lastRemaining(n-1,m);
        return (m+x)%n;
    }
}
