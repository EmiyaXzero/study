package com.my;

/**
 * @author shang
 * @title: MaxDepth
 * @projectName study
 * @description: 二叉树的最大深度
 * @date 2020/1/15-10:31
 */
public class MaxDepth {
    /**
     * DFS(深度优先搜索)
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            //到叶子节点了
            return 0;
        }else {
            //获取当前节点左右节点长度，返回大于的+1（本身）
            int leftDepth = maxDepth(root.left)+1;
            int rightDepth = maxDepth(root.right)+1;
            return Math.max(leftDepth,rightDepth);
        }
    }
}
