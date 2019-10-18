package com.dang.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * N叉树的前序遍历(https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/)
 * @author dht
 * @date 18/10/2019
 */
public class Q_589 {

    public static void main(String[] args) {
        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);
        List<Node> children3 = new LinkedList<>();
        children3.add(node5);
        children3.add(node6);
        Node node3 = new Node(3, children3);
        List<Node> childrenRoot = new LinkedList<>();
        childrenRoot.add(node3);
        childrenRoot.add(node2);
        childrenRoot.add(node4);
        Node root = new Node(1, childrenRoot);

        Q_589 q_589 = new Q_589();
        List<Integer> res = q_589.preorder(root);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preOrderTraversal(root, result);
        return result;
    }

    private void preOrderTraversal(Node root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                preOrderTraversal(child, result);
            }
        }
    }

}
