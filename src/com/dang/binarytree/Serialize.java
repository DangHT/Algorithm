package com.dang.binarytree;

import java.util.Stack;

/**
 * 二叉树序列化
 * @author dht925nerd@126.com
 * @date 2019/03/03
 */
public class Serialize {

    /**
     * 先序序列化
     * @param root 树根节点
     * @return 序列化字符串
     */
    public static String preOrderSerialize(TreeNode root){
        if (root == null) return null;
        StringBuilder builder = new StringBuilder();
        preOrderSerialize(root, builder);
        return builder.toString();
    }

    private static void preOrderSerialize(TreeNode root, StringBuilder builder) {
        if (builder == null) return;
        if (root == null) {
            builder.append("#!");
        } else {
            builder.append(root.val).append("!");
            preOrderSerialize(root.left, builder);
            preOrderSerialize(root.right, builder);
        }
    }

    /**
     * 中序序列化
     * @param root 树根节点
     * @return 序列化字符串
     */
    public static String inOrderSerialize(TreeNode root){
        if (root == null) return null;
        StringBuilder builder = new StringBuilder();
        inOrderSerialize(root, builder);
        return builder.toString();
    }

    private static void inOrderSerialize(TreeNode root, StringBuilder builder) {
        if (builder == null) return;
        if (root == null) {
            builder.append("#!");
        } else {
            inOrderSerialize(root.left, builder);
            builder.append(root.val).append("!");
            inOrderSerialize(root.right, builder);
        }
    }

    /**
     * 后序序列化
     * @param root 树根节点
     * @return 序列化字符串
     */
    public static String postOrderSerialize(TreeNode root){
        if (root == null) return null;
        StringBuilder builder = new StringBuilder();
        postOrderSerialize(root, builder);
        return builder.toString();
    }

    private static void postOrderSerialize(TreeNode root, StringBuilder builder) {
        if (builder == null) return;
        if (root == null) {
            builder.append("#!");
        } else {
            postOrderSerialize(root.left, builder);
            postOrderSerialize(root.right, builder);
            builder.append(root.val).append("!");
        }
    }

    /**
     * 先序序列反序列化
     * @param s 先序序列化字符串
     * @return 反序列化树根节点
     */
    public static TreeNode preOrderReSerialize(String s){
        if (s == null) return null;
        String[] nodes = s.split("!");
        int i = 0; boolean flag = false;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[i++]));
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (i < nodes.length){
            if ("#".equals(nodes[i])){
                if (stack.empty()) break;
                temp = stack.pop();
                flag = true;
            } else {
                if (!flag) {
                    temp.left = new TreeNode(Integer.parseInt(nodes[i]));
                    temp = temp.left;
                } else {
                    temp.right = new TreeNode(Integer.parseInt(nodes[i]));
                    temp = temp.right;
                }
                flag = false;
                stack.push(temp);
            }
            i++;
        }
        return root;
    }

    /**
     * 中序序列反序列化
     * @param s 中序序列化字符串
     * @return 反序列化树根节点
     */
    public static TreeNode inOrderSerialize(String s){
        //TODO
        return null;
    }

    /**
     * 后序序列反序列化
     * @param s 后序序列化字符串
     * @return 反序列化树根节点
     */
    public static TreeNode postOrderSerialize(String s){
        //TODO
        return null;
    }

}
