package com.my;

import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5400. 旅行终点站
 * @Date: 2020/5/3 10:32
 **/
public class DestCity {
    public String destCity(List<List<String>> paths) {
        Map<String,String> allValue = new HashMap<>();
        for (List<String> path : paths){
            allValue.put(path.get(0),path.get(1));
        }
        for (List<String> path : paths){
            if(!allValue.containsKey(path.get(1))){
                return path.get(1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        DestCity destCity = new DestCity();
        List<List<String>> paths = new ArrayList<>();
        paths.add(new ArrayList<>(){{
            add("qMTSlfgZlC");
            add("ePvzZaqLXj");
        }});
        paths.add(new ArrayList<>(){{
            add("xKhZXfuBeC");
            add("TtnllZpKKg");
        }});
        paths.add(new ArrayList<>(){{
            add("ePvzZaqLXj");
            add("sxrvXFcqgG");
        }});
        paths.add(new ArrayList<>(){{
            add("sxrvXFcqgG");
            add("xKhZXfuBeC");
        }});
        paths.add(new ArrayList<>(){{
            add("TtnllZpKKg");
            add("OAxMijOZgW");
        }});
        System.out.println(destCity.destCity(paths));
    }
}
