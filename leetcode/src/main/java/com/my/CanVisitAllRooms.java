package com.my;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author shanghang
 * @title: CanVisitAllRooms
 * @projectName study
 * @description: 841. 钥匙和房间
 * @date 2020/8/31-11:59
 */
public class CanVisitAllRooms {
    /**
     * 深度优先
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        int count = 1;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0;i<rooms.get(0).size();i++){
            deque.add(rooms.get(0).get(i));
        }
        while (!deque.isEmpty()){
            int idx = deque.removeFirst();
            if(visited[idx]){
                continue;
            }else {
                visited[idx] = true;
                count++;
                List<Integer> integers = rooms.get(idx);
                for (int i : integers){
                    deque.add(i);
                }
            }
        }
        return count==rooms.size();
    }
}
