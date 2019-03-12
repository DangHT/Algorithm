package com.dang.binarysearch;

import com.dang.binarytree.TreeNode;

/**
 * 给定一棵完全二叉树的头节点 head, 返回这棵树
 * 的节点个数, 如果完全二叉树的节点数为 N,
 * 请实现时间复杂度低于 O(N) 的解法
 * @author dht925nerd@126.com
 * @date 2019/03/11
 */
public class Puzzle5 {

    private static int solution(TreeNode root){
        if (root == null) return 0;
        TreeNode temp = root;
        int treeHight = 0, rightHight = 0;
        while (temp != null) {
            temp = temp.left;
            treeHight++;
        }
        temp = root.right;
        while (temp != null){
            temp = temp.left;
            rightHight++;
        }
        if (rightHight == treeHight - 1){
            return (int) (Math.pow(2, rightHight) + solution(root.right));
        }
        return (int) (Math.pow(2, rightHight) + solution(root.left));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
        System.out.println(solution(root));
    }

}
