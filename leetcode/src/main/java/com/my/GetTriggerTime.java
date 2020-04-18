package com.my;

import java.util.*;

/**
 * @author shang
 * @title: getTriggerTime
 * @projectName study
 * @description: TODO
 * @date 2020/4/18-15:52
 */
public class GetTriggerTime {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        Map<Integer,int[]> map =new HashMap<>();
        int a = 0;
        int b = 0;
        int c = 0;
        int[] result = new int[requirements.length];
        for (int i = 0;i<requirements.length;i++){
            map.put(i,requirements[i]);
            if(requirements[i][0] == 0 && requirements[i][1] == 0 && requirements[i][2] ==0){
                result[i] = 0;
            }else {
                result[i] = -1;
            }
        }
        for (int i = 0 ;i<increase.length ;i++){
            a +=increase[i][0];
            b +=increase[i][1];
            c +=increase[i][2];
           Iterator<Integer> it = map.keySet().iterator();
           while (it.hasNext()){
               int temp = it.next();
               if(result[temp] == -1){
                   if(a>= requirements[temp][0] && b >=requirements[temp][1] && c>=requirements[temp][2]){
                       result[temp] = i+1;
                       it.remove();
                   }
               }
           }
        }
        return result;
    }

    public static void main(String[] args) {
        GetTriggerTime getTriggerTime = new GetTriggerTime();
        System.out.println(getTriggerTime.getTriggerTime2(new int[][]{{0, 4, 5}, {4, 8, 8}, {8, 6, 1}, {10, 10, 0}}, new int[][]{{12, 11, 16}, {20, 2, 6}, {9, 2, 6}, {10, 18, 3}, {8, 14, 9}}));
    }


    public int[] getTriggerTime2(int[][] increase, int[][] requirements) {
        Map<int[],Integer> map =new HashMap<>();
        int a = 0;
        int b = 0;
        int c = 0;
        int[] result = new int[requirements.length];
        for (int i = 0;i<requirements.length;i++){
            map.put(requirements[i],i);
            if(requirements[i][0] == 0 && requirements[i][1] == 0 && requirements[i][2] ==0){
                result[i] = 0;
            }else {
                result[i] = -1;
            }
        }
        Arrays.sort(requirements, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0]+o1[1]+o1[2])-(o2[0]+o2[1]+o2[2]);
            }
        });
        int max = 0;
        for (int i = 0 ;i<increase.length ;i++){
            a +=increase[i][0];
            b +=increase[i][1];
            c +=increase[i][2];
            boolean flag = false;
            for(int j = max ;j<requirements.length;j++){
                if(result[map.get(requirements[j])] == -1){
                    if(a+b+c< (requirements[j][0]+requirements[j][1]+requirements[j][2])){
                        break;
                    }
                    if(a>= requirements[j][0] && b >=requirements[j][1] && c>=requirements[j][2]){
                        result[map.get(requirements[j])] = i+1;
                    }else{
                        if(!flag){
                            max = j;
                            flag = true;
                        }
                    }
                }
            }
        }
        return result;
    }
}
