package com.dang.leetcode.tree;

import com.dang.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树的直径(https://leetcode-cn.com/problems/diameter-of-binary-tree/)
 * @author dht
 * @date 24/09/2019
 */
public class Q_543 {

    private static Map<TreeNode, Integer> heightNote = new HashMap<>();
    private static Map<TreeNode, Integer> diameterNote = new HashMap<>();

    private static int ans;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree_01(root));
    }

    public static int diameterOfBinaryTree_01(TreeNode root) {
        if (root == null) return 0;
        int left = diameterOfBinaryTree_01(root.left);
        int right = diameterOfBinaryTree_01(root.right);
        return Math.max(getDiameter(root), Math.max(left, right));
    }

    public static int diameterOfBinaryTree_02(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    private static int getDiameter(TreeNode root) {
        if (root == null) return 0;
        if (diameterNote.containsKey(root)) {
            return diameterNote.get(root);
        }
        int diameter = getHeight(root.left) + getHeight(root.right);
        diameterNote.put(root, diameter);
        return diameter;
    }

    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left, right;
        if (heightNote.containsKey(root.left)) {
            left = heightNote.get(root.left);
        } else {
            left = getHeight(root.left) + 1;
            heightNote.put(root.left, left);
        }
        if (heightNote.containsKey(root.right)) {
            right = heightNote.get(root.right);
        } else {
            right = getHeight(root.right) + 1;
            heightNote.put(root.right, right);
        }
        return Math.max(left, right);
    }

    private static int depth(TreeNode root) {
        if (root == null) return 0;
        int L = depth(root.left);
        int R = depth(root.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }

}
