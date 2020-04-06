package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/6 10:26
 **/
public class MinDistance {
    /**
     * 将word1,word2的转换变成word1[0...i-i] word2[o...j-1]+word1[i]-->word2[j]的次数
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        //保存word1[0..i] to word2[0..j]所需要的距离
        int[][] cost = new int[n+1][m+1];
        for (int i = 0 ;i<=n;i++){
            cost[i][0] = i;
        }
        for (int j=0 ;j<=m;j++){
            cost[0][j] = j;
        }
        for (int i = 1 ;i<=n;i++){
            for (int j = 1 ;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    //如果word1[i] == word2[j],则最小距离就是word1[0..i-1] 到word2[0...j-1]的距离
                    cost[i][j] = cost[i-1][j-1];
                }else {
                    //转换的距离存在三种情况
                    // 1.[0..i-1][0..j-1]+ [i to j(1)的值]
                    int tempCost1 = cost[i-1][j-1]+1;
                    // 2.[0..i]到[0..j-1]+add[j]的值
                    int tempCost2 = cost[i][j-1]+1;
                    // 3.[0..i-1]到[0..j]+remove[i]的值
                    int tempCost3 = cost[i-1][j]+1;
                    cost[i][j] = Math.min(Math.min(tempCost1,tempCost2),tempCost3);
                }
            }
        }
        return cost[n][m];
    }
}
