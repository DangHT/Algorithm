package com.dang.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一棵二叉树的头节点 head, 请按照指定格式打印节点
 *                _1_
 *               /   \
 *              2    3
 *             /    / \
 *            4    5   6
 *                / \
 *               7   8
 *   要求格式:
 *   1
 *   2 3
 *   4 5 6
 *   7 8
 * @author dht925nerd@126.com
 * @date 2019/03/15
 */
public class Puzzle1 {

    private static void solution(TreeNode root){
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode last, nlast = null, temp;
        last = root;
        queue.add(last);
        while (!queue.isEmpty()){
            temp = queue.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null) {
                queue.add(temp.left);
                nlast = temp.left;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                nlast = temp.right;
            }
            if (last == temp){
                last = nlast;
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        solution(root);
    }

}
