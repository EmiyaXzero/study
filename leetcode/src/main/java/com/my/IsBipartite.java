package com.my;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shanghang
 * @title: IsBipartite
 * @projectName study
 * @description: 785. 判断二分图
 * @date 2020/7/16-20:59
 */
public class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        a.add(0);
        for (int i = 0;i<graph[0].length;i++){
            b.add(graph[0][i]);
        }
        int type = 1;
        for (int i = 1;i<graph.length;i++){
            if(a.contains(i)){
                type = 2;
            }else if(b.contains(i)){
                type = 1;
            }else{
                for(int j = 0 ;j<graph[i].length;j++){
                    if(a.contains(graph[i][j])){
                        type = 1;
                        break;
                    }else if(a.contains(graph[i][j])){
                        type = 2;
                        break;
                    }
                }
                if(type == 1){
                    b.add(i);
                }else {
                    a.add(i);
                }
            }
            for(int j = 0 ;j<graph[i].length;j++){
                int temp = graph[i][j];
                if (type == 1){
                    if(b.contains(temp)){
                        return false;
                    }else {
                        a.add(temp);
                    }
                }else {
                    if(a.contains(temp)){
                        return false;
                    }else {
                        b.add(temp);
                    }
                }
            }

        }

        return true;
    }
}
