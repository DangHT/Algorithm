package com.dang.leetcode.tree;

import java.util.Arrays;

/**
 * N叉树的最大深度(https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/)
 * @author dht
 * @date 25/09/2019
 */
public class Q_559 {

    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);
        Node node3 = new Node(3, Arrays.asList(node5, node6));
        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);
        Node root = new Node(1, Arrays.asList(node3, node2, node4));
        Q_559 q_559 = new Q_559();
        System.out.println(q_559.maxDepth(root));
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children == null || root.children.size() == 0) {
            return 1;
        }
        int max = 0;
        for (Node node : root.children) {
            max = Math.max(max, maxDepth(node));
        }
        return max + 1;
    }

}
