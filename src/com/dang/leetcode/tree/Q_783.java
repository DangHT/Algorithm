package com.dang.leetcode.tree;

import com.dang.binarytree.TreeNode;

/**
 * 二叉搜索树结点最小距离(https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/submissions/)
 * @author DangHT
 * @date 26/12/2019
 */
public class Q_783 {

    private int dist = Integer.MAX_VALUE;
    private TreeNode pre;

    public int minDiffInBST(TreeNode root) {
        if (root == null) return dist;
        minDiffInBST(root.left);
        if(pre != null) dist = Math.min(dist, root.val - pre.val);
        if (dist == 1) return dist;
        pre = root;
        minDiffInBST(root.right);
        return dist;
    }

}
