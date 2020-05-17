package com.my;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5397. 最简分数
 * @Date: 2020/5/16 22:36
 **/
public class SimplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        HashSet<String> strings = new HashSet<>();
        for (int i=2;i<=n;i++){
            for (int j = 1;j<=i-1;j++){
                String s = j/gcd(j,i)+"/"+i/gcd(j,i);
                if(!strings.contains(s)){
                    strings.add(s);
                }
            }
        }
        Iterator<String> iterator = strings.iterator();
        List<String> result = new ArrayList<>();
        while (iterator.hasNext()){
            result.add(iterator.next());
        }
        return result;
    }

    /**
     * 辗转相除法化简,求最大公约数
     */
    public static int gcd(int x, int y){
        if(y == 0){
            return x;
        }else {
            return gcd(y,x%y);
        }
    }
}
