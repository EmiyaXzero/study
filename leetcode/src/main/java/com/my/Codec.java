package com.my;

import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @description:297. 二叉树的序列化与反序列化
 * @Date: 2020/6/16 21:42
 **/
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        return sb.toString();
    }
    public StringBuffer enCode(TreeNode root,StringBuffer sb){
        if(null == root){
            sb.append("null,");
            return sb;
        }
        sb.append(root.val);
        sb.append(",");
        sb = enCode(root.left,sb);
        sb = enCode(root.right,sb);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ss = data.split(",");
        List<String> linkedSS = new LinkedList<String>(Arrays.asList(ss));
        return deCode(linkedSS);
    }

    private TreeNode deCode(List<String> linkedSS) {
        if (linkedSS.get(0).equals("null")){
            linkedSS.remove(0);
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(linkedSS.get(0)));
        linkedSS.remove(0);
        treeNode.left = deCode(linkedSS);
        treeNode.right = deCode(linkedSS);
        return treeNode;
    }
}
