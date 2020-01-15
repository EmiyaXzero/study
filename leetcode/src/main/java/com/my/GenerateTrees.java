package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/1/15 20:41
 **/
public class GenerateTrees {
    /**
     * 从序列 1 ..n 取出数字 i 并以它作为当前树的根节点。 那么就有 i - 1 个元素可以用来构造左子树，
     * 而另外的 n - i 个元素可以用于构造右子树。
     * 最后我们将会得到 G(i - 1) 棵不同的左子树，以及 G(n - i) 棵不同的右子树，其中 G 为卡特兰数。
     * @param n
     * @return
     */
    public static List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return null;
        }
        return getTree(1,n);
    }

    public static List<TreeNode> getTree(int start, int end){
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        if(start>end){
            treeNodes.add(null);
            return treeNodes;
        }
        for (int i =start ;i<=end;i++){
            //以i当根节点
            List<TreeNode> leftTreeNode = getTree(start,i-1);
            List<TreeNode> rightTreeNode = getTree(i+1,end);
            for (TreeNode leftNode : leftTreeNode) {
               for (TreeNode rightNode : rightTreeNode){
                   TreeNode treeNode = new TreeNode(i);
                   treeNode.left = leftNode;
                   treeNode.right = rightNode;
                   treeNodes.add(treeNode);
               }
            }
        }
        return treeNodes;
    }

    public static void main(String[] args) {
        generateTrees(3);
    }
}
