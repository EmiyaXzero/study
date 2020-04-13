package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/8 12:13
 **/
public class MovingCount {
    public int movingCount(int m, int n, int k) {
        int count = 0;
        int[][] allTemp = new int[m][n];
        //计算出每行有多少就好了,不行，会存在后面如果能往下走就失败
        for (int i = 0 ;i<m;i++){
            //先从第i行往右
            int tempCountI =getInt(i);
            if(tempCountI>k){
                break;
            }
            for (int j = 0 ;j<n;j++){
                int tempCountJ = getInt(j);
                if(tempCountI+tempCountJ <=k && allTemp[i][j] == 0){
                    allTemp[i][j] = 1;
                    count++;
                }else {
                    continue;
                }
            }
        }
        return count;
    }

    public int getInt(int x){
        int tempCountI =0;
        while (x>0){
            tempCountI +=x%10;
            x /=10;
        }
        return tempCountI;
    }

    int[][] visited;
    int m ,n ,k;

    public int movingCountByDFS(int m ,int n ,int k){
        this.visited = new int[m][n];
        this.m = m;
        this.n = n;
        this.k = k;
        return dfs(0,0,0,0);
    }
    /**
     * 深度优先遍历DFS,先朝一个方向搜索，再回溯到上一个节点往另一个方向搜索
     * @param i 当前节点所在的i
     * @param j 当前节点所在的j
     * @param s1
     * @param s2
     * @return
     */
    public int dfs(int i ,int j ,int s1,int s2){
        if(i<0 || i>=m || j<0 || j>=n || s1+s2>k || visited[i][j] == 1){
            //数组越界，或者大于限制k，以及已经访问过
            return 0;
        }
        visited[i][j] = 1;
        return 1+dfs(i+1,j,getInt(i+1),s2)+dfs(i,j+1,s1,getInt(j+1));
    }


    public static void main(String[] args) {
        MovingCount m = new MovingCount();
        System.out.println(m.movingCount(38, 15, 9));
    }
}
