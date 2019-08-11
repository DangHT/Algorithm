package com.dang.leetcode;

import com.dang.binarytree.TreeNode;

/**
 * 二叉搜索树的最近公共祖先(https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
 * @author dht
 * @date 11/08/2019
 */
public class Q_235 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        TreeNode p = root.left;
        TreeNode q = root.left.right;
        TreeNode tmp = lowestCommonAncestor(root, p, q);
        System.out.println(tmp == null ? "null" : tmp.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        TreeNode tmp = root;
        while (tmp != null) {
            if (tmp.val < p.val && tmp.val < q.val)
                tmp = tmp.right;
            else if (tmp.val > p.val && tmp.val > q.val)
                tmp = tmp.left;
            else
                break;
        }
        return tmp;
    }

}
