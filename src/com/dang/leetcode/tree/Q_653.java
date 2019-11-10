package com.dang.leetcode.tree;

import com.dang.binarytree.TreeNode;

import java.util.*;

/**
 * 两数之和 IV - 输入 BST(https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/)
 * @author dht
 * @date 09/11/2019
 */
public class Q_653 {

    public static void main(String[] args) {
        Q_653 q_653 = new Q_653();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(q_653.findTarget(root, 4));
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();

        inorderTravel(root, values);

        int head = 0, tail = values.size() - 1;
        while (head < tail) {
            int sum = values.get(head) + values.get(tail);
            if (sum == k)
                return true;
            if (sum < k) {
                tail--;
            }
            if (sum > k) {
                head++;
            }
        }

        return false;
    }

    private void inorderTravel(TreeNode root, List<Integer> values) {
        if (root == null) return;
        inorderTravel(root.left, values);
        values.add(root.val);
        inorderTravel(root.right, values);
    }

}
