package com.my;

import java.util.*;

/**
 * @author shang
 * @title: NumWays
 * @projectName study
 * @description:
 * @date 2020/4/18-15:15
 */
public class NumWays {
    Map<Integer, List<Integer>> all = new HashMap();
    HashSet<String> set = new HashSet();
    public int numWays(int n, int[][] relation, int k) {
        for (int i = 0;i<relation.length;i++){
            //将所有值放到map
            if(all.containsKey(relation[i][0])){
                all.get(relation[i][0]).add(relation[i][1]);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(relation[i][1]);
                all.put(relation[i][0],list);
            }
        }
        String s = "0";
        getCount(n,k-1,all.get(0),s);
        return set.size();
    }

    public void getCount(int n , int k,List<Integer> temp,String s){
        if(temp == null){
            return;
        }
        if(k == 0){
            for (int i = 0;i<temp.size();i++){

                if(temp.get(i) == n-1){
                    String ss = s+temp.get(i);
                    if(!set.contains(ss)){
                        set.add(ss);
                    }
                }
            }
        }else{
            for (int i = 0 ;i <temp.size();i++){
                String ss = s+ temp.get(i);
                getCount(n,k-1,all.get(temp.get(i)),ss);
            }
        }
    }

    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        numWays.numWays(5,new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}},3);
    }
}
