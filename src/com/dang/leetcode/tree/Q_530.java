package com.dang.leetcode.tree;

import com.dang.binarytree.TreeNode;

/**
 * 二叉搜索树的最小绝对差(https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/)
 * @author dht
 * @date 22/09/2019
 */
public class Q_530 {

    private static int min = Integer.MAX_VALUE;
    private static TreeNode preNode;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        System.out.println(getMinimumDifference(root));
    }

    public static int getMinimumDifference(TreeNode root) {
        inOrderTravel(root);
        return min;
    }

    private static void inOrderTravel(TreeNode root) {
        if (root == null) return;
        inOrderTravel(root.left);
        if (preNode != null) {
            min = Math.min(min, Math.abs(root.val - preNode.val));
        }
        preNode = root;
        inOrderTravel(root.right);
    }

}
