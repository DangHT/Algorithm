package com.dang.leetcode.tree;

import com.dang.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层平均值(https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/)
 * @author dht
 * @date 01/11/2019
 */
public class Q_637 {

    public static void main(String[] args) {
        Q_637 q_637 = new Q_637();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);

        List<Double> results = q_637.averageOfLevels(root);
        for (double d : results) {
            System.out.print(d + " ");
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> results = new ArrayList<>();
        TreeNode cur = root, last = root, nlast = root;
        long sum = 0, count = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            sum += cur.val;
            count++;
            if (cur.left != null) {
                queue.add(cur.left);
                nlast = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nlast = cur.right;
            }
            if (last == cur) {
                results.add( (double)sum / (double) count);
                sum = count = 0;
                last = nlast;
            }
        }
        return results;
    }

}
