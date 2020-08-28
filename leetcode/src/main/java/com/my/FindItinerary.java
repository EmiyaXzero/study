package com.my;

import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @description:332. 重新安排行程
 * @Date: 2020/8/27 22:17
 **/
public class FindItinerary {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> list = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets){
            String src = ticket.get(0);
            String target = ticket.get(1);
            if(!map.containsKey(src)){
                PriorityQueue<String> queue = new PriorityQueue<>();
                queue.add(target);
                map.put(src,queue);
            }else {
                map.get(src).add(target);
            }
        }
        dfs("JFK");
        return list;
    }

    private void dfs(String src) {
        PriorityQueue<String> target = map.get(src);
        while (target!=null && !target.isEmpty()){
            dfs(target.poll());
        }
        list.add(0,src);
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> ticket1 = new ArrayList<>();
        List<String> ticket2 = new ArrayList<>();
        ticket1.add("MUC");
        ticket1.add("LHR");
        ticket2.add("JFK");
        ticket2.add("MUC");
        tickets.add(ticket1);
        tickets.add(ticket2);
        new FindItinerary().findItinerary(tickets);
    }
}
