package com.dang.nwpu.y2018;

import com.dang.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 编程查找某个字符组成的二叉树中, 是否存在两个相同的节点
 * 例如二叉树中存在两个节点值均为'c'
 * @author dht925nerd@126.com
 * @date 2019/02/27
 */
public class Solution8 {

    private static boolean hasSameNode(TreeNode root){
        if (root == null) return false;
        List<Integer> elements = new ArrayList<>();
        return traversal(root, elements);
    }

    private static boolean traversal(TreeNode root, List<Integer> elements){
        if (root == null || elements == null) return false;
        if (elements.contains(root.val)) {
            System.out.println("包含相同节点值:" + root.val);
            return true;
        }
        elements.add(root.val);
        return traversal(root.left, elements) || traversal(root.right, elements);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(hasSameNode(root));
    }

}
