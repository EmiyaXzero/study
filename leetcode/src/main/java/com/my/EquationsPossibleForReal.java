package com.my;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: shanghang
 * @Project:study
 * @description:990. 等式方程的可满足性
 * @Date: 2020/6/8 22:05
 **/
public class EquationsPossibleForReal {
    public boolean equationsPossible(String[] equations) {
        int len = equations.length;
        int[] parent = new int[26];
        for (int i =0 ;i<26;i++){
            parent[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!'){
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (find(parent,index1) == find(parent,index2)){
                    return false;
                }
            }
        }
        return true;
    }

    private void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    private int find(int[] parent, int index1) {
       while (parent[index1] != index1){
           parent[index1] = parent[parent[index1]];
           index1 = parent[index1];
       }
       return index1;
    }


    public static void main(String[] args) {
        EquationsPossibleForReal equationsPossible = new EquationsPossibleForReal();
        equationsPossible.equationsPossible(new String[]{"a==b","b==a"});
    }
}
