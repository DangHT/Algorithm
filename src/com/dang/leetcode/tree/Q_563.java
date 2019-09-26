package com.dang.leetcode.tree;

import com.dang.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树的坡度(https://leetcode-cn.com/problems/binary-tree-tilt/)
 * @author dht
 * @date 25/09/2019
 */
public class Q_563 {

    private int sum = 0;

    private Map<TreeNode, Integer> sumNote = new HashMap<>();
    private Map<TreeNode, Integer> tiltNote = new HashMap<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        Q_563 q_563 = new Q_563();
        System.out.println(q_563.findTilt_01(root));
    }

    public int findTilt_01(TreeNode root) {
        counter(root);
        return sum;
    }

    public int findTilt_02(TreeNode root) {
        if (root == null) return 0;
        return countTilt(root) + findTilt_01(root.left) + findTilt_01(root.right);
    }

    private int countTilt(TreeNode root) {
        if (root == null) return 0;
        if (tiltNote.containsKey(root)) {
            return tiltNote.get(root);
        }
        int tilt = Math.abs(countSum(root.right) - countSum(root.left));
        tiltNote.put(root, tilt);
        return tilt;
    }

    private int countSum(TreeNode root) {
        if (root == null) return 0;
        if (sumNote.containsKey(root)) return sumNote.get(root);
        int sum = 0;
        sum += sumNote.containsKey(root.left) ? sumNote.get(root.left) : countSum(root.left);
        sum += sumNote.containsKey(root.right) ? sumNote.get(root.right) : countSum(root.right);
        sum += root.val;
        sumNote.put(root, sum);
        return sum;
    }

    private int counter(TreeNode root) {
        if (root == null) return 0;
        int left = counter(root.left);
        int right = counter(root.right);
        sum += Math.abs(left - right);
        return left + right + root.val;
    }

}
