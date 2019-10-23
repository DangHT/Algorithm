package com.dang.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * N叉树的后序遍历(https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)
 * @author dht
 * @date 18/10/2019
 */
public class Q_590 {

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

        Q_590 q_590 = new Q_590();
        List<Integer> res = q_590.postorder(root);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postOrderTraversal(root, result);
        return result;
    }

    private void postOrderTraversal(Node root, List<Integer> result) {
        if (root == null) return;
        if (root.children != null) {
            for (Node child : root.children) {
                postOrderTraversal(child, result);
            }
        }
        result.add(root.val);
    }

}
