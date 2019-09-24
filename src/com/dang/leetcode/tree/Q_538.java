package com.dang.leetcode.tree;

import com.dang.binarytree.Traversal;
import com.dang.binarytree.TreeNode;

/**
 * 把二叉搜索树转换为累加树(https://leetcode-cn.com/problems/convert-bst-to-greater-tree/)
 * @author dht
 * @date 23/09/2019
 */
public class Q_538 {

    private static int cur = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        root.right.right = new TreeNode(20);
        root.right.left = new TreeNode(8);
        root.right.right.left = new TreeNode(15);
        root.right.left.right = new TreeNode(10);
        root = convertBST(root);
        Traversal.inOrder(root);
    }

    public static TreeNode convertBST(TreeNode root) {
        travelAndAdd(root);
        return root;
    }

    private static void travelAndAdd(TreeNode root) {
        if (root == null) return;
        travelAndAdd(root.right);
        int temp = root.val;
        root.val += cur;
        cur += temp;
        travelAndAdd(root.left);
    }

}
