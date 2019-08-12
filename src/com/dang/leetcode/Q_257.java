package com.dang.leetcode;

import com.dang.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径(https://leetcode-cn.com/problems/binary-tree-paths/)
 * @author dht
 * @date 12/08/2019
 */
public class Q_257 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String> paths = binaryTreePaths_01(root);
        for (String s : paths) {
            System.out.println(s);
        }
    }

    public static List<String> binaryTreePaths_01(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        List<String> paths = new ArrayList<>();
        travel(root, builder, paths);
        return paths;
    }

    private static void travel(TreeNode root, StringBuilder builder, List<String> paths) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            builder.append(root.val);
            paths.add(builder.toString());
            return;
        }
        builder.append(root.val + "->");
        int size = builder.length();
        travel(root.left, builder, paths);
        builder.delete(size, builder.length());
        travel(root.right, builder, paths);
    }


    public static List<String> binaryTreePaths_02(TreeNode root) {
        List<String> paths = new ArrayList();
        construct_paths(root, "", paths);
        return paths;
    }

    private static void construct_paths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            path += root.val;
            if ((root.left == null) && (root.right == null))
                paths.add(path);
            else {
                path += "->";
                construct_paths(root.left, path, paths);
                construct_paths(root.right, path, paths);
            }
        }
    }


}
