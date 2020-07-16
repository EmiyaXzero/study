package com.my;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: shanghang
 * @Project:study
 * @description:785. 判断二分图
 * @Date: 2020/7/16 22:23
 **/
public class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        for(int i = 0;i<graph.length;i++){
            if(a.contains(i) || b.contains(i)){
                continue;
            }
            if(!dfs(i,a,b,graph)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int i ,Set<Integer> a,Set<Integer> b ,int[][] graph){
        if(a.contains(i)){
            return true;
        }
        if(b.contains(i)){
            return false;
        }
        a.add(i);
        for(int j = 0 ;j<graph[i].length;j++){
            if(!dfs(graph[i][j],b,a,graph)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsBipartite isBipartite = new IsBipartite();
        isBipartite.isBipartite(new int[][]{{3},{2,4},{1},{0,4},{1,3}});
    }
}
