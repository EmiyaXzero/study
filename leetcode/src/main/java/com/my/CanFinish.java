package com.my;

import java.util.*;

/**
 * @author shanghang
 * @title: CanFinish
 * @projectName study
 * @description: 207. 课程表
 * @date 2020/8/4-13:42
 */
public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> pre = new HashMap<>();
        for(int[] ints : prerequisites){
            List<Integer> lists = pre.getOrDefault(ints[0],new ArrayList<>());
            lists.add(ints[1]);
            pre.put(ints[0],lists);
        }
        for (int i = 0 ;i<numCourses ;i++){
            if(!pre.containsKey(i)){
                continue;
            }else {
                Set<Integer> tempUsed = new HashSet<>();
                List<Integer> lists = pre.get(i);
                if(!doIt(tempUsed,lists,pre)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean doIt(Set<Integer> tempUsed, List<Integer> lists, Map<Integer, List<Integer>> pre) {
        if(lists == null){
            return true;
        }
        for (int i : lists){
            if(!pre.containsKey(i)){
                continue;
            }
            else if(tempUsed.contains(i)){
                return false;
            }else {
                tempUsed.add(i);
                List<Integer> listss = pre.get(i);
                if(!doIt(tempUsed,listss,pre)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new CanFinish().canFinish(3,new int[][]{{0,1},{0,2},{1,2}});
    }

    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinishTrue(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i=0;i<numCourses ;i++ ){
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        for(int[] ints : prerequisites){
            edges.get(ints[1]).add(ints[0]);
        }
        for (int i = 0;i<numCourses && valid;i++){
            if(visited[i] == 0){
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int i) {
        visited[i] = 1;
        for (int v : edges.get(i)){
            if(visited[v] == 0){
                dfs(v);
                if(!valid){
                    return;
                }
            }else if(visited[v] == 1){
                //闭环了
                valid = false;
                return;
            }
        }
        visited[i] = 2;
    }


}
