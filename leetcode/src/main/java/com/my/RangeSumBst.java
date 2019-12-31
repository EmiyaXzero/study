package com.my;

/**
 * 二叉搜索树的范围和
 * @author shang
 */
public class RangeSumBst {
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    /**
     * 树的遍历
     * @param root
     * @param L
     * @param R
     * @return
     */
    public static int rangeSumBST(TreeNode root, int L, int R) {
        return getSum(root,L,R);
    }

    public static int getSum(TreeNode root, int L, int R){
        int temp = root.val;
        if(temp <L || temp>R){
            temp=0;
        }
        if(root.left == null && root.left == null){
            return temp;
        }else if(root.left == null){
            return temp+getSum(root.right,L,R);
        }else if(root.right == null){
            return temp + getSum(root.left,L,R);
        }else {
            return temp + getSum(root.left,L,R)+getSum(root.right,L,R);
        }
    }

    /**
     * 二叉搜索树比当前小的放左节点，大的放右节点
     * @param
     */
    public static int getSum2(TreeNode root, int L, int R){
        if(root == null){
            return 0;
        }
        int temp = root.val;
        if(temp >= L && temp <=R){
            return temp + getSum2(root.left,L,R)+getSum(root.right,L,R);
        }else if(temp>R){
            //直接取左节点
            return 0+getSum2(root.left,L,R);
        }else if(temp<L){
            //直接取右节点
            return 0+getSum2(root.right,L,R);
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        System.out.println(rangeSumBST(treeNode, 7, 15));
    }
}
