package com.my;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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
        int[] visited = new int[jump.length];
        Queue<int[]> q = new LinkedList<>();
        //队列保存已经访问过的值
        q.add(new int[]{0,0});
        //已经访问过的赋值为1
        visited[0] = 1;
        //左边访问的最大值
        int maxLeftIdx = 0;
        //BFS遍历
        while(!q.isEmpty()){
            int[] cur = q.poll();
            //向右跳,获取rightIdx
            int rightIdx = jump[cur[0]]+cur[0];
            if(rightIdx >= jump.length){
                //最早跳出的时候步数最小
                return cur[1]+1;
            }else {
                //表示没访问过
                if(visited[rightIdx] == 0){
                    q.add(new int[]{rightIdx,cur[1]+1});
                    visited[rightIdx] = 1;
                }
            }
            //向左跳
            for (int i = maxLeftIdx+1; i < cur[0]; i++) {
                if (visited[i]==0){
                    q.add(new int[]{i,cur[1]+1});
                    visited[i] = 1;
                }
            }
            maxLeftIdx = cur[0];
        }
        return -1;
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

    /**
     * 从后往前动态规划
     * @param jump
     * @return
     */
    public int minJump2(int[] jump) {
        int[] dp = new int[jump.length];
        dp[dp.length-1] =1;
        for (int i = jump.length-2 ;i>=0 ;i--){
            //从后向前推，如果jump[i]+1超过了数组直接为1，如果没有为dp[jump[i]+i]+1
            dp[i] = jump[i]+i>=jump.length?1:dp[jump[i]+i]+1;
            //又因为当前i的值会影响i+1到dp.length位，只有当dp[j]>=dp[i]+1的时候才需要去覆盖掉dp[j]的值
            for (int j = i+1;j<dp.length && dp[j] >= dp[i]+1;j++){
                dp[j] = dp[i]+1;
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        MinJump minJump = new MinJump();
        System.out.println(minJump.minJump(new int[]{3,7,6,1,4,3,7,8,1,2,8,5,9,8,3,2,7}));
    }
}
