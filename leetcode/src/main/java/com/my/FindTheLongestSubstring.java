package com.my;

/**
 * @author shang
 * @title: FindTheLongestSubstring
 * @projectName study
 * @description: 1371. 每个元音包含偶数次的最长子字符串
 * @date 2020/5/20-13:27
 */
public class FindTheLongestSubstring {

    public int findTheLongestSubstring(String s) {
        int[][] dp = new int[s.length()+1][5];
        for (int i = 1 ;i<=s.length();i++){
           switch (s.charAt(i-1)){
               case 'a':
                   dp[i][0] = dp[i-1][0]+1;
                   dp[i][1] = dp[i-1][1];
                   dp[i][2] = dp[i-1][2];
                   dp[i][3] = dp[i-1][3];
                   dp[i][4] = dp[i-1][4];
                   break;
               case 'e':
                   dp[i][0] = dp[i-1][0];
                   dp[i][1] = dp[i-1][1]+1;
                   dp[i][2] = dp[i-1][2];
                   dp[i][3] = dp[i-1][3];
                   dp[i][4] = dp[i-1][4];
                   break;
               case 'i':
                   dp[i][0] = dp[i-1][0];
                   dp[i][1] = dp[i-1][1];
                   dp[i][2] = dp[i-1][2]+1;
                   dp[i][3] = dp[i-1][3];
                   dp[i][4] = dp[i-1][4];
                   break;
               case 'o':
                   dp[i][0] = dp[i-1][0];
                   dp[i][1] = dp[i-1][1];
                   dp[i][2] = dp[i-1][2];
                   dp[i][3] = dp[i-1][3]+1;
                   dp[i][4] = dp[i-1][4];
                   break;
               case 'u':
                   dp[i][0] = dp[i-1][0];
                   dp[i][1] = dp[i-1][1];
                   dp[i][2] = dp[i-1][2];
                   dp[i][3] = dp[i-1][3];
                   dp[i][4] = dp[i-1][4]+1;
                   break;
               default:
                   dp[i][0] = dp[i-1][0];
                   dp[i][1] = dp[i-1][1];
                   dp[i][2] = dp[i-1][2];
                   dp[i][3] = dp[i-1][3];
                   dp[i][4] = dp[i-1][4];
                   break;
           }
        }
        if(((dp[s.length()][0]&1) == 0)&&
                ((dp[s.length()][1]&1) == 0)&&
                ((dp[s.length()][2]&1) == 0)&&
                ((dp[s.length()][3]&1) == 0)&&
                ((dp[s.length()][4]&1) == 0)){
            return s.length();
        }
        int max = 0;
        if(((dp[1][0]&1) == 0)&&
                ((dp[1][1]&1) == 0)&&
                ((dp[1][2]&1) == 0)&&
                ((dp[1][3]&1) == 0)&&
                ((dp[1][4]&1) == 0)){
            max = 1;
        }
        for (int i = 1;i<dp.length;i++){
            for (int j = i+1;j<dp.length;j++){
                if((dp[j][0]-dp[i][0]==0?(dp[j][0]&1)==0:(dp[j][0]-dp[i][0]&1) == 0) &&
                        (dp[j][1]-dp[i][1]==0?(dp[j][1]&1)==0:(dp[j][1]-dp[i][1]&1) == 0) &&
                        (dp[j][2]-dp[i][2]==0?(dp[j][2]&1)==0:(dp[j][2]-dp[i][2]&1) == 0) &&
                        (dp[j][3]-dp[i][3]==0?(dp[j][3]&1)==0:(dp[j][3]-dp[i][3]&1) == 0) &&
                        (dp[j][4]-dp[i][4]==0?(dp[j][4]&1)==0:(dp[j][4]-dp[i][4]&1) == 0)){
                    max = Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FindTheLongestSubstring findTheLongestSubstring = new FindTheLongestSubstring();
        System.out.println(findTheLongestSubstring.findTheLongestSubstring("eleetminicoworoep"));
    }
}
