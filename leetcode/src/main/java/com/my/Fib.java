package com.my;

import java.util.HashMap;

/**
 * @author shang
 * @title: Fib
 * @projectName study
 * @description: 斐波那契数
 * @date 2020/1/14-16:06
 */
public class Fib {
    HashMap<Integer,Integer> value = new HashMap<>(16);

    public int fib(int N) {
        if(value.containsKey(N)){
            return value.get(N);
        }
        if(N == 1){
            return 1;
        }else if (N == 0 ){
            return 0;
        }else {
            int result = fib(N-1)+fib(N-2);
            value.put(N,result);
            return result;
        }
    }
}
