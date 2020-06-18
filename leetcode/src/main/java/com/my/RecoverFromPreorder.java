package com.my;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: shanghang
 * @Project:study
 * @description:1028. 从先序遍历还原二叉树
 * @Date: 2020/6/18 23:09
 **/
public class RecoverFromPreorder {
    public TreeNode recoverFromPreorder(String S) {
        Deque<TreeNode> path = new LinkedList<>();
        int pos = 0;
        while (pos<S.length()){
            int level = 0;
            //判断-的多少
            while (S.charAt(pos) == '-'){
                level++;
                pos++;
            }
            int value = 0;
            while (pos<S.length() && Character.isDigit(S.charAt(pos))){
                value = value*10+ S.charAt(pos) - '0';
                ++pos;
            }
            TreeNode treeNode = new TreeNode(value);
            if (level == path.size()){
                if (!path.isEmpty()){
                    path.peek().left = treeNode;
                }
            }else {
                while (level != path.size()){
                    path.pop();
                }
                path.peek().right = treeNode;
            }
            path.push(treeNode);
        }
        while (path.size()>1){
            path.pop();
        }
        return path.pop();
    }
}
