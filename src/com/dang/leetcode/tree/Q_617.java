package com.dang.leetcode.tree;

import com.dang.binarytree.TreeNode;

/**
 * 合并二叉树(https://leetcode-cn.com/problems/merge-two-binary-trees/)
 * @author dht
 * @date 28/10/2019
 */
public class Q_617 {

    public static void main(String[] args) {

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (null == t1 || null == t2) {
            return null == t1 ? t2 : t1;
        }
        TreeNode tmp = new TreeNode(t1.val + t2.val);
        tmp.left = mergeTrees(t1.left, t2.left);
        tmp.right = mergeTrees(t1.right, t2.right);
        return tmp;
    }

}
