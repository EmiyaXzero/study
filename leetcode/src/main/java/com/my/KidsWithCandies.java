package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5384. 拥有最多糖果的孩子
 * @Date: 2020/5/2 22:57
 **/
public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int candie:candies){
            max = candie>max?candie:max;
        }
        for (int candie:candies){
            if(candie+extraCandies>=max){
                result.add(true);
            }else {
                result.add(false);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        KidsWithCandies kidsWithCandies = new KidsWithCandies();
        kidsWithCandies.kidsWithCandies(new int[]{12,1,12},10);
    }
}
