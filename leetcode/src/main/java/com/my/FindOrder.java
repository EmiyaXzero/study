package com.my;

import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @description:课程表 II
 * @Date: 2020/5/17 10:14
 **/
public class FindOrder {
    public static class Node{
        int curseId;
        Node next;
        Node(int curseId){
            this.curseId = curseId;
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses<1){
            return new int[]{};
        }
        int[] res = new int[numCourses];
        //----------构建图节点---------------
        Node[] graphy = new Node[numCourses];
        for (int i = 0 ;i<numCourses;i++){
            graphy[i] = new Node(i);
        }
        //统计入度
        int[] degree = new int[numCourses];
        //标记是否使用
        boolean[] used = new boolean[numCourses];
        for(int[] item : prerequisites){
            Node start = graphy[item[1]];
            Node temp = start.next;
            start.next = new Node(item[0]);
            start.next.next = temp;
            //度+1
            degree[item[0]]++;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        //将如度为0的入队列
        for (int i = 0; i <degree.length ; i++) {
            if(degree[i] == 0){
                deque.add(i);
                used[i] = true;
            }
        }
        int count = 0;
        while (!deque.isEmpty()){
            int k = deque.removeFirst();
            //记录课程
            res[count++] = k;
            used[k] = true;
            Node node = graphy[k].next;
            while (node != null){
                if(!used[node.curseId]){
                    //入度减一
                    degree[node.curseId]--;
                    if(degree[node.curseId] == 0){
                        deque.add(node.curseId);
                        used[node.curseId] = true;
                    }
                }
                node = node.next;
            }
        }
        if(count == numCourses){
            return res;
        }else {
            return new int[]{};
        }

    }

    public int[] findOrderDFS(int numCourses, int[][] prerequisites) {
        if(numCourses<1){
            return new int[]{};
        }
        //统计入度
        int[] degree = new int[numCourses];
        //标记是否使用
        boolean[] used = new boolean[numCourses];
        int[] res = new int[numCourses];
        Map<Integer,List<Integer>> alls = new HashMap<>();
        //统计度
        for (int[] item:prerequisites){
            degree[item[0]]++;
            if(alls.containsKey(item[1])){
                alls.get(item[1]).add(item[0]);
            }else {
                alls.put(item[1],new ArrayList<>(){{add(item[0]);}});
            }
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i= 0 ;i<numCourses;i++){
            if(degree[i] == 0){
                //将度为0的入队
                deque.add(i);
            }
        }
        int count = 0;
        while (!deque.isEmpty()){
            int k = deque.removeFirst();
            used[k] = true;
            //入结果集
            res[count++] = k;
            List<Integer> list = alls.get(k);
            if (list!=null){
                for (int i = 0;i<list.size();i++){
                    if(!used[list.get(i)]){
                        degree[list.get(i)]--;
                        if(degree[list.get(i)] == 0){
                            deque.add(list.get(i));
                        }
                    }
                }
            }
        }
        if(count == numCourses){
            return res;
        }else {
            return new int[]{};
        }
    }
    public int[] findOrderNoMap(int numCourses, int[][] prerequisites) {
        if(numCourses<1){
            return new int[]{};
        }
        //统计入度
        int[] degree = new int[numCourses];
        //标记是否使用
        boolean[] used = new boolean[numCourses];
        int[] res = new int[numCourses];
        //统计度
        for (int[] item:prerequisites){
            degree[item[0]]++;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i= 0 ;i<numCourses;i++){
            if(degree[i] == 0){
                //将度为0的入队
                deque.add(i);
            }
        }
        int count = 0;
        while (!deque.isEmpty()){
            int k = deque.removeFirst();
            used[k] = true;
            //入结果集
            res[count++] = k;
            for (int[] item : prerequisites){
                if(item[1] == k && !used[item[0]]){
                    degree[item[0]]--;
                    if(degree[item[0]] == 0){
                        deque.add(item[0]);
                    }
                }
            }
        }
        if(count == numCourses){
            return res;
        }else {
            return new int[]{};
        }
    }

    public static void main(String[] args) {
        FindOrder findOrder = new FindOrder();
        findOrder.findOrderNoMap(3,new int[][]{{2,1},{1,0}});
    }
}
