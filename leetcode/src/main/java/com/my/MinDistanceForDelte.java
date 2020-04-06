package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/6 11:51
 **/
public class MinDistanceForDelte {
    /**
     * 两个字符串的删除操作,动态规划
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] cost = new int[n+1][m+1];
        for (int i = 0 ;i<=n; i++){
            //记录word1从[0...n]每一个到空串需要操作的次数
            cost[i][0] = i;
        }
        for (int i = 0 ;i<=m; i++){
            //记录word2从[0...m]每一个到空串需要操作的次数
            cost[0][i] = i;
        }

        for (int i = 1;i<=n;i++){
            for (int j = 1 ;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    cost[i][j] = cost[i-1][j-1];
                }else {
                    //删除存在的情况
                    //1.word1[0..i] 删到word2[o..j-1]+ 删除word2[j]
                    int tempCost1 = cost[i][j-1]+1;
                    //2.word1[0..i] 删到word2[0..j]+删除word1[i]
                    int tempCost2 = cost[i-1][j]+1;
                    //3.word1[0..i-1]删到word2[0..j-1]+删除word1[i]+删除word2[j]
                    int tempCost3 = cost[i-1][j-1]+2;
                    cost[i][j] = Math.min(Math.min(tempCost1,tempCost2),tempCost3);
                }
            }
        }
        return cost[n][m];
    }

    /**
     * 最长公共子序列，找到最长的公共子序列返回m+n-2*最长公共子序列长度
     */
    public int minDistance2(String word1, String word2) {
        int[][] cost = new int[word1.length()+1][word2.length()+1];
        return word1.length()+word2.length()-2*lcs(word1,word2,word1.length(),word2.length(),cost);
    }

    /**
     * 递归返回字符串word1,word2的最长公共子序列长度
     * @param word1
     * @param word2
     * @param length1
     * @param length2
     * @return
     */
    public int lcs(String word1, String word2,int length1,int length2,int[][] cost){
        if(length1==0 || length2==0){
            return 0;
        }
        if(cost[length1][length2]>0){
            return cost[length1][length2];
        }
        if(word1.charAt(length1-1) == word2.charAt(length2-1)){
            cost[length1][length2] = lcs(word1,word2,length1-1,length2-1,cost)+1;
        }else {
            //不等存在两种情况
            // 1word1[0..length1-1]和word2[0..length2]存在公共子串
            // 2word1[0..length]和word2[0..length2-1]存在公共子串
            cost[length1][length2] = Math.max(lcs(word1,word2,length1-1,length2,cost),lcs(word1, word2, length1, length2-1,cost));
        }
        return cost[length1][length2];
    }

    /**
     * 动态规划获取最长lcs
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance3(String word1, String word2) {
        int[][] cost = new int[word1.length()+1][word2.length()+1];
        for (int i = 1; i<=word1.length();i++){
            for (int j = 1 ; j<=word2.length();j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    cost[i][j] = cost[i-1][j-1]+1;
                }else {
                    //存在两种情况
                    //1.wor1[0..i]和word2[0..j-1]有公共子串
                    //2.word1[0..i-1]和word2[0..j]有公共子串
                    cost[i][j] = Math.max(cost[i][j-1],cost[i-1][j]);
                }
            }
        }
        return word1.length()+word2.length()-2*cost[word1.length()][word2.length()];
    }

}
