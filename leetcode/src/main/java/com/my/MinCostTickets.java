package com.my;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shang
 * @title: MincostTickets
 * @projectName study
 * @description: 983. 最低票价
 * @date 2020/5/6-12:05
 */
public class MinCostTickets {
    Map<Integer,Integer> valus = new HashMap<>();
    public int mincostTickets(int[] days, int[] costs) {
        return getMin(days,0,costs);
    }

    public int getMin(int[] days,int curIdx,int[] costs){
        if(curIdx == days.length-1){
            return Math.min(Math.min(costs[0],costs[1]),costs[2]);
        }
        if(curIdx >=days.length){
            return 0;
        }

        int sevenDay = days[curIdx]+6;
        int day30 = days[curIdx]+29;
        boolean isFirst7=false;
        boolean isFirst30 = false;
        int nextDay = getMin(days,curIdx+1,costs)+costs[0];
        int min = nextDay;
        for (int i = curIdx ;i<days.length;i++){
            if(days[i]>sevenDay && !isFirst7){
                isFirst7=true;
                int key = valus.containsKey(i)?valus.get(i):getMin(days,i,costs);
                min = Math.min(min,key+costs[1]);
            }
            if(days[i]>day30){
                isFirst30 = true;
                int key = valus.containsKey(i)?valus.get(i):getMin(days,i,costs);
                min = Math.min(min,key+costs[2]);
                break;
            }
        }
        if(!isFirst7){
            min = Math.min(min,costs[1]);
        }
        if(!isFirst30){
            min = Math.min(min,costs[2]);
        }
        if(!valus.containsKey(curIdx)){
            valus.put(curIdx,min);
        }
        return min;
    }

    public static void main(String[] args) {
        MinCostTickets minCostTickets = new MinCostTickets();
        System.out.println(minCostTickets.mincostTickets(new int[]{2,3,5,6,7,8,9,10,11,17,18,19,23,26,27,29,31,32,33,34,35,36,38,39,40,41,42,43,44,45,47,51,54,55,57,58,64,65,67,68,72,73,74,75,77,78,81,86,87,88,89,91,93,94,95,96,98,99}, new int[]{2, 7, 15}));
    }
}
