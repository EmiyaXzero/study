package com.my;

/**
 * @author shanghang
 * @title: MinCameraCover
 * @projectName study
 * @description: 968. 监控二叉树
 * @date 2020/9/22-20:52
 */
public class MinCameraCover {

    private int ans = 0;

    public int minCameraCover(TreeNode root) {
        if(root == null) {
            return ans;
        }
        if(dfs(root) == 2) {
            ans++;
        }
        return ans;
    }

    /**
     *
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        if(root == null){
            return 1;
        }
        int left = dfs(root.left) ,right =dfs(root.right);
        if(left == 2 || right == 2){
            ans ++;
            return 0;
        }else if(left == 0 || right == 0){
            return 1;
        }else {
            return 2;
        }
    }
}
