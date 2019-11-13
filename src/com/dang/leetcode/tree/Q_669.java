package com.dang.leetcode.tree;

import com.dang.binarytree.TreeNode;

/**
 * 修剪二叉搜索树(https://leetcode-cn.com/problems/trim-a-binary-search-tree/)
 * @author dht
 * @date 11/11/2019
 */
public class Q_669 {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null || L > R) return null;
        if (L > root.val) return trimBST(root.right, L, R);
        if (R < root.val) return trimBST(root.left, L, R);
        root.left = trimBST(root.left, L, root.val - 1);
        root.right = trimBST(root.right, root.val + 1, R);
        return root;
    }

}
