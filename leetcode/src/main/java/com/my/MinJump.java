package com.my;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author shang
 * @title: MinJump
 * @projectName study
 * @description: 最小跳跃次数
 * @date 2020/4/19-16:23
 */
public class MinJump {
    HashMap<Integer,Integer> countMap = new HashMap<>();
    HashSet<Integer> usedIdx = new HashSet<>();
    public int minJump(int[] jump) {
        return doRun(jump,0);
    }

    public int doRun(int[] jump ,int idx){
        if(idx >= jump.length){
            return 0;
        }
        if(idx == 0){
            usedIdx.add(idx);
            return doRun(jump,idx+jump[idx])+1;
        }else {
            int min = Integer.MAX_VALUE;
            //先计算右边
            if(countMap.containsKey(idx+jump[idx])){
                min = Math.min(min,countMap.get(idx+jump[idx])+1);
            }else {
                usedIdx.add(idx);
                min = Math.min(min,doRun(jump,idx+jump[idx])+1);
            }
           for (int i = idx-1;i>=0;i--){
               if(usedIdx.contains(i)){
                   continue;
               }
               if(countMap.containsKey(i)){
                   min = Math.min(min,countMap.get(i)+1);
               }else {
                   min = Math.min(min,doRun(jump,i)+1);
               }
           }
           if(!countMap.containsKey(idx)){
               countMap.put(idx,min);
               usedIdx.remove(idx);
           }
           return min;
        }
    }

    public static void main(String[] args) {
        MinJump minJump = new MinJump();
        System.out.println(minJump.minJump(new int[]{3,7,6,1,4,3,7,8,1,2,8,5,9,8,3,2,7}));
    }
}
