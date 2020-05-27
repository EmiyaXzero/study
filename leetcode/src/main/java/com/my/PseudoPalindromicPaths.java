package com.my;

import java.io.IOException;
import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5418. 二叉树中的伪回文路径
 * @Date: 2020/5/24 11:13
 **/
public class PseudoPalindromicPaths {
    List<List<Integer>> paths = new ArrayList<>();
    public int pseudoPalindromicPaths (TreeNode root) {
        int result = 0;
        getPaths(root,new ArrayList<>());
        for (List<Integer> path : paths){
            Map<Integer,Integer> keys = new HashMap<>(path.size());
            for (int i : path){
                keys.put(i,keys.getOrDefault(i,0)+1);
            }
            Iterator<Integer> key = keys.keySet().iterator();
            int jLen = 0;
            boolean jFlag = true;
            while (key.hasNext()){
                if((keys.get(key.next())&1) == 1){
                    jLen++;
                    if(jLen == 2){
                        jFlag = false;
                        break;
                    }
                }
            }
            if(jFlag){
                result++;
            }
        }
        return result;
    }

    public void getPaths(TreeNode root,List<Integer> path){
        List<Integer> newPath = new ArrayList<>(path);
        newPath.add(root.val);
        if(root.left == null && root.right == null){
            paths.add(newPath);
            return;
        }else if(root.left == null && root.right !=null){
            getPaths(root.right,newPath);
        }else if(root.left != null && root.right ==null){
            getPaths(root.left,newPath);
        }else {
            getPaths(root.left,newPath);
            getPaths(root.right,newPath);
        }
    }


    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        String line = "[2,3,1,3,1,null,1]";

        TreeNode root = stringToTreeNode(line);

        System.out.println(new PseudoPalindromicPaths().pseudoPalindromicPaths(root));
    }
}
