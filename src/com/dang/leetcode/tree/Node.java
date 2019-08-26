package com.dang.leetcode.tree;

import java.util.List;

/**
 * N叉树节点
 * @author dht
 * @date 26/08/2019
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
