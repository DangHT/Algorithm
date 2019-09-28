package com.dang.leetcode.tree;

import com.dang.binarytree.TreeNode;

/**
 * 另一个树的子树(https://leetcode-cn.com/problems/subtree-of-another-tree/)
 * @author dht
 * @date 27/09/2019
 */
public class Q_572 {

    public static void main(String[] args) {
        Q_572 q_572 = new Q_572();
        TreeNode s = new TreeNode(3);
        s.right = new TreeNode(5);
        s.left = new TreeNode(4);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        System.out.println(q_572.isSubtree(s, t));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (t == null) return true;
        if (isSame(s, t)) return true;
        return isSubtree(s.right, t) || isSubtree(s.left, t);
    }

    private boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (!a.val.equals(b.val)) return false;
        return isSame(a.right, b.right) && isSame(a.left, b.left);
    }

}
