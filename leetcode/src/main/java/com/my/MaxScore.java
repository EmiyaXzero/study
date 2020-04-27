package com.my;

/**
 * @author shang
 * @title: MaxScore
 * @projectName study
 * @description: 分割字符串的最大得分
 * @date 2020/4/26-10:32
 */
public class MaxScore {
    public int maxScore(String s) {
        int max = Integer.MIN_VALUE;
        for (int i = 1;i<s.length();i++){
            max = Math.max(getLeft(0,s,i)+getRight(i,s.length(),s),max);
        }
        return max;
    }

    private int getRight(int i1, int i2, String s) {
        String temp = s.substring(i1,i2);
        int count = 0;
        for (int j = 0; j <temp.length() ; j++) {
            if(temp.charAt(j) == '1'){
                count++;
            }
        }
        return count;
    }

    private int getLeft(int i, String s, int i1) {
        String temp = s.substring(0,i1);
        int count = 0;
        for (int j = 0; j <temp.length() ; j++) {
            if(temp.charAt(j) == '0'){
                count++;
            }
        }
        return count;
    }

    /**
     * 可获得的最大点数
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        if(cardPoints.length<=k){
            for (int cardPoint : cardPoints) {
                sum+=cardPoint;
            }
            return sum;
        }
        int[] leftCount = new int[k];
        int[] rightCount = new int[k];
        int temp = 0;
        for (int i =0 ;i< k;i++){
            temp+=cardPoints[i];
            leftCount[i] = temp;
        }
        temp = 0;
        for (int i =0 ;i< k;i++){
            temp+=cardPoints[cardPoints.length-1-i];
            rightCount[i] = temp;
        }
        //组合
        sum = Math.max(leftCount[k-1],rightCount[k-1]);
        for (int i=0 ;i<k-1;i++){
            sum = Math.max(leftCount[i]+rightCount[k-2-i],sum);
        }
        return sum;
    }



    public static void main(String[] args) {
        MaxScore maxScore = new MaxScore();
        System.out.println(maxScore.maxScore(new int[]{1,79,80,1,1,1,200,1},3));
    }

}
