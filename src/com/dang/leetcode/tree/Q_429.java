package com.dang.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树的层序遍历(https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)
 * @author dht
 * @date 26/08/2019
 */
public class Q_429 {

    public static void main(String[] args) {
        Node n5 = new Node(5, new ArrayList<>());
        Node n6 = new Node(6, new ArrayList<>());
        List<Node> c1 = new ArrayList<>();
        c1.add(n5);
        c1.add(n6);
        Node n3 = new Node(3, c1);
        Node n2 = new Node(2, new ArrayList<>());
        Node n4 = new Node(4, new ArrayList<>());
        List<Node> c2 = new ArrayList<>();
        c2.add(n3);
        c2.add(n2);
        c2.add(n4);
        Node root = new Node(1, c2);
        List<List<Integer>> result = levelOrder(root);
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> level;
        while (!queue.isEmpty()) {
            int count = queue.size();
            level = new ArrayList<>();
            while (count-- > 0) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }

}
