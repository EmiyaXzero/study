package com.my;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author shang
 * @title: FindWhetherExistsPath
 * @projectName study
 * @description: TODO
 * @date 2020/4/10-16:19
 */
public class FindWhetherExistsPath {
    /**
     * 将所有next放到map然后一层一层递归
     * @param n
     * @param graph
     * @param start
     * @param target
     * @return
     */
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Map<Integer, Set<Integer>> allMap = new HashMap<>();
        for (int i =0 ;i<graph.length;i++){
            if(graph[i][0] == start && graph[i][1] == target){
                return true;
            }
            if(allMap.containsKey(graph[i][0])){
                allMap.get(graph[i][0]).add(graph[i][1]);
            }else {
                HashSet<Integer> set = new HashSet();
                set.add(graph[i][1]);
                allMap.put(graph[i][0],set);
            }
        }
        return find(allMap.get(start),target,allMap);
    }

    public boolean find(Set<Integer> set , int target,Map<Integer, Set<Integer>>  allMap){
        if(set == null){
            return false;
        }
        if(set.contains(target)){
            return true;
        }else {
            for (Integer o : set) {
                if(find(allMap.get(o),target,allMap)){
                    return true;
                }
            }
        }

        return false;
    }
}
