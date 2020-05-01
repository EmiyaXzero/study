package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/5/1 11:06
 **/
public class DistributeCandies {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result  = new int[num_people];
        int i = 0;
        int j = 1;
        while (candies>0){
            if(j>candies){
                result[i%num_people]+=candies;
                break;
            }
            candies-=j;
            result[i%num_people]+=j++;
            i++;
        }
        return result;
    }
}
