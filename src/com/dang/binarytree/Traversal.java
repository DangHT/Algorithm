package com.dang.binarytree;

import java.util.Stack;

/**
 * 二叉树遍历
 * @author dht925nerd@126.com
 * @date 2019/02/25
 */
public class Traversal {

    /**
     * 先序遍历(递归)
     * @param root 树根节点
     */
    public static void preOrder(TreeNode root){
        if (root == null) { return; }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历(递归)
     * @param root 树根节点
     */
    public static void inOrder(TreeNode root){
        if (root == null) { return; }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    /**
     * 后序遍历(递归)
     * @param root 树根节点
     */
    public static void postOrder(TreeNode root){
        if (root == null) { return; }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 先序遍历(非递归)
     * @param root 树根节点
     */
    public static void preOrderNonRecursive(TreeNode root){
        if (root == null) { return; }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        stack.push(root);
        while (!stack.empty()){
            temp = stack.pop();
            System.out.print(temp.val + " ");
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
    }

    /**
     * 中序遍历(非递归)
     * @param root 树根节点
     */
    public static void inOrderNonRecursive(TreeNode root){
        if (root == null){ return; }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        do {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            System.out.print(temp.val + " ");
            temp = temp.right;
        } while (!stack.empty() || temp != null);
    }

    /**
     * 后序遍历(非递归, 双栈实现)
     * @param root 树根节点
     */
    public static void postOrderNonRecursiveWithTwoStack(TreeNode root){
        if (root == null){ return; }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode temp = root;
        s1.push(temp);
        while (!s1.empty()){
            temp = s1.pop();
            s2.push(temp);
            if (temp.left != null)s1.push(temp.left);
            if (temp.right != null)s1.push(temp.right);
        }
        while (!s2.empty()){
            System.out.print(s2.pop().val + " ");
        }
    }

    /**
     * 后序遍历(非递归, 单栈实现)
     * @param root 树根节点
     */
    public static void postOrderNonRecursiveWithOneStack(TreeNode root){
        if (root == null){ return; }
        Stack<TreeNode> stack = new Stack<>();
        //最近一次弹出并打印的节点
        TreeNode h = root;
        //当前的栈顶节点
        TreeNode c = null;
        stack.push(h);
        while (!stack.empty()){
            c = stack.peek();
            if (c.left != null && h != c.left && h != c.right){
                stack.push(c.left);
            } else if (c.right != null && h != c.right){
                stack.push(c.right);
            } else {
                System.out.print(c.val + " ");
                h = stack.pop();
            }
        }
    }
}
