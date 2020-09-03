package com.my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: shanghang
 * @Project:study
 * @description:51. N 皇后
 * @Date: 2020/9/3 23:47
 **/
public class SolveNQueens {
    List<List<String>> ans  = new LinkedList<>();
    List<Integer> columns = new ArrayList<>();
    List<String> qChar = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i<n;i++){
            sb.append(".");
        }
        for (int i=0 ;i<n;i++){
            qChar.add(sb.replace(i,i+1,"Q").toString());
            sb.replace(i,i+1,".");
        }
        solveRecursively(n);
        return ans;
    }

    private void solveRecursively( int n) {
        if(columns.size() == n){
            List<String> currAns = new ArrayList<>();
            for (int i =0;i<n;i++){
                currAns.add(qChar.get(columns.get(i)));
            }
            ans.add(currAns);
            return;
        }
        boolean flag = false;
        int k = columns.size();
        for (int i = 0;i<n;i++){
            flag = false;
            for (int j = 0 ;j<k;j++){
                if(j == columns.get(j) || (k-i == j-columns.get(j)) || (k+i == j+columns.get(j))){
                    flag=true;
                    break;
                }
            }
            if(flag){
                continue;
            }
            columns.add(i);
            solveNQueens(n);
            columns.remove(columns.size()-1);
        }
        return;
    }

}
