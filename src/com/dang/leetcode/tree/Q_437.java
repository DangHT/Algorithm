package com.dang.leetcode.tree;

import com.dang.binarytree.TreeNode;

/**
 * 路径总和III(https://leetcode-cn.com/problems/path-sum-iii/)
 * @author dht
 * @date 26/08/2019
 */
public class Q_437 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
//        root.left = new TreeNode(4);
//        root.left.left = new TreeNode(11);
//        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//        root.left.right.right = new TreeNode(1);
//        root.right.left = new TreeNode(13);
        root.right.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(5);
        root.right.right.right.right = new TreeNode(5);
        System.out.println(pathSum(root, 3));
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return countPath(root, sum)
                + pathSum(root.left, sum)
                + pathSum(root.right, sum);
    }

    private static int countPath(TreeNode root, int sum) {
        if (root == null) return 0;
        sum -= root.val;
        int count = 0;
        if (sum == 0) count++;

        count += countPath(root.right, sum);
        count += countPath(root.left, sum);

        return count;
    }


}
