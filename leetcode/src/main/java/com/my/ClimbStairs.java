package com.my;

import java.util.HashMap;

/**
 * @author shang
 * @title: ClimbStairs
 * @projectName study
 * @description: 爬楼梯
 * @date 2020/1/14-16:15
 */
public class ClimbStairs {
    /**
     * 爬楼梯有一次爬一层，和一次爬两层的方法，那么爬到N层有多少层？
     * 可以反过来思考，到N层只有N-1,N-2两种解法，那么N-1就有N-2,N-3两种，那么直接到第二层
     * @param n
     * @return
     */
    HashMap<Integer,Integer> value = new HashMap<>(16);

    public int climbStairs(int n) {
        if(value.containsKey(n)){
            return value.get(n);
        }
        if(n <= 2){
            return n;
        }else {
            int result = climbStairs(n-1)+climbStairs(n-2);
            value.put(n,result);
            return result;
        }
    }
}
