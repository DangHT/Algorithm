package com.dang.leetcode.tree;

import com.dang.binarytree.TreeNode;

/**
 * 根据二叉树创建字符串(https://leetcode-cn.com/problems/construct-string-from-binary-tree/)
 * @author dht
 * @date 27/10/2019
 */
public class Q_606 {

    private StringBuilder builder;

    public static void main(String[] args) {
        Q_606 q_606 = new Q_606();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);

        System.out.println(q_606.tree2str(root));
    }

    public String tree2str(TreeNode t) {
        builder = new StringBuilder();
        preTraversal(t);
        return builder.toString();
    }

    private void preTraversal(TreeNode root) {
        if (null == root) return;

        builder.append(root.val);
        builder.append("(");

        preTraversal(root.left);

        if ('(' == builder.charAt(builder.length() - 1) && null == root.right) {
            builder.deleteCharAt(builder.length() - 1);
        } else {
            builder.append(")");
        }

        builder.append("(");
        preTraversal(root.right);
        if ('(' == builder.charAt(builder.length() - 1)) {
            builder.deleteCharAt(builder.length() - 1);
        } else {
            builder.append(")");
        }
    }

}
