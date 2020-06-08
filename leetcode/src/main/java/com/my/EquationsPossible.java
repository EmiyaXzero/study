package com.my;

import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @description:990. 等式方程的可满足性
 * @Date: 2020/6/8 22:05
 **/
public class EquationsPossible {
    /**
     * 单词到号码的映射
     */
    private Map<Character,Integer> wordId = new HashMap<>();
    /**
     * 图的边  Integer[0] 表示关系0等于1不等于  Integer[1] 表示关联的数字
     */
    private Map<Integer,Boolean>[] edges;

    /**
     * 构建图多一层就不行了
     * @param equations
     * @return
     */
    public boolean equationsPossible(String[] equations) {
        int id = 0;
        for (String s : equations){
            if(!wordId.containsKey(s.charAt(0))){
                wordId.put(s.charAt(0),id++);
            }
            if(!wordId.containsKey(s.charAt(3))){
                wordId.put(s.charAt(3),id++);
            }
        }
        edges = new HashMap[id];
        for (String s: equations){
            if (s.substring(1,3).equals("==")){
                int idx1 = wordId.get(s.charAt(0));
                int idx4 = wordId.get(s.charAt(3));
                if(edges[idx1] != null){
                    if (edges[idx1].containsKey(idx4)){
                        if(!edges[idx1].get(idx4)){
                            return false;
                        }
                    }else {
                        edges[idx1].put(idx4,true);
                    }
                }else {
                    edges[idx1] = new HashMap<>();
                    edges[idx1].put(idx4,true);
                }
                if(edges[idx4] != null){
                    if (edges[idx4].containsKey(idx1)){
                        if(!edges[idx4].get(idx1)){
                            return false;
                        }
                    }else {
                        edges[idx4].put(idx1,true);
                    }
                }else {
                    edges[idx4] = new HashMap<>();
                    edges[idx4].put(idx1,true);
                }
            }else {
                int idx1 = wordId.get(s.charAt(0));
                int idx4 = wordId.get(s.charAt(3));
                if(edges[idx1] != null){
                    if (edges[idx1].containsKey(idx4)){
                        if(edges[idx1].get(idx4)){
                            return false;
                        }
                    }else {
                        edges[idx1].put(idx4,false);
                    }
                }else {
                    edges[idx1] = new HashMap<>();
                    edges[idx1].put(idx4,true);
                }
                if(edges[idx4] != null){
                    if (edges[idx4].containsKey(idx1)){
                        if(edges[idx4].get(idx1)){
                            return false;
                        }
                    }else {
                        edges[idx4].put(idx1,false);
                    }
                }else {
                    edges[idx4] = new HashMap<>();
                    edges[idx4].put(idx1,false);
                }
            }
        }
        for (int i = 0 ;i<edges.length;i++){
            Map<Integer,Boolean> map = edges[i];
            for (Iterator<Integer> it = map.keySet().iterator(); it.hasNext(); ) {
                Integer integer = it.next();
                Map<Integer,Boolean> map2  = edges[integer];
                if(map.get(integer)){
                    //相等的
                    for (Iterator<Integer> it2 = map2.keySet().iterator(); it2.hasNext(); ){
                        Integer intege2 = it2.next();
                        if(map.containsKey(intege2) && !map2.get(intege2) && map.get(intege2)){
                            return false;
                        }
                    }
                }else {
                    //不等的
                    for (Iterator<Integer> it2 = map2.keySet().iterator(); it2.hasNext(); ){
                        Integer intege2 = it2.next();
                        if(map.containsKey(intege2) && map2.get(intege2) && map.get(intege2)){
                            return false;
                        }
                    }
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {
        EquationsPossible equationsPossible = new EquationsPossible();
        equationsPossible.equationsPossible(new String[]{"a==b","b==a"});
    }
}
