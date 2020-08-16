package com.my;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: shanghang
 * @Project:study
 * @description:133. 克隆图
 * @Date: 2020/8/12 22:06
 **/
public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Node[] nodes = new Node[101];
    boolean[] visited = new boolean[101];

//    public Node cloneGraph(Node node) {
//        if(node == null){
//            return null;
//        }
//        dfs(node);
//        Node[] nesNodes = new Node[101];
//        for (int i = 0 ;i<101;i++){
//            nesNodes[i] = new Node(i,new ArrayList<>());
//        }
//        for (int i = 0 ;i<101;i++){
//            if(visited[i]){
//                Node node1 = nodes[i];
//                for (Node neighbor : node1.neighbors) {
//                    nesNodes[i].neighbors.add(nesNodes[neighbor.val]);
//                }
//            }
//        }
//
//        return nesNodes[node.val];
//    }

    private void dfs(Node node) {
        if(visited[node.val]){
            return;
        }
        visited[node.val] = true;
        nodes[node.val] = node;
        for (Node tempNode : node.neighbors){
            dfs(tempNode);
        }
    }

    private Map<Node,Node> visted = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }else {
            if(visted.containsKey(node)){
                return visted.get(node);
            }
            Node newNode = new Node(node.val,new ArrayList<>());
            visted.put(node,newNode);
            for (Node tempNode : node.neighbors){
                newNode.neighbors.add(cloneGraph(tempNode));
            }
            return newNode;
        }
    }
}
