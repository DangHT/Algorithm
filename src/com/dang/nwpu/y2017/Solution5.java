package com.dang.nwpu.y2017;

import com.dang.binarytree.Traversal;
import com.dang.binarytree.TreeNode;

/**
 * 请编写程序完成二叉树的遍历
 * @author dht925nerd@126.com
 * @date 2019/02/28
 */
public class Solution5 {

    /**
     * 遍历二叉树
     * {@link Traversal}
     * @param root 树根节点
     */
    private static void traversalBinaryTree(TreeNode root){
        Traversal.preOrder(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        traversalBinaryTree(root);
    }

}
