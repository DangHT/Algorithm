package com.dang.binarytree.binarysearchtree;

import com.dang.binarytree.TreeNode;

/**
 * 二叉搜索树
 * @author dht925nerd@126.com
 * @date 2019/03/20
 */
public class BSTree {
    /**
     * 树根节点
     */
    public TreeNode root;

    /**
     * 搜索记忆热点
     */
    private TreeNode hot;

    /**
     * 树节点总数
     */
    private int size;

    public BSTree(int n) {
        root = new TreeNode(n);
        size = 0;
        hot = root;
    }

    /**
     * 搜索值为 n 的节点
     * @param n 待查数值
     * @return 查询结果
     */
    public TreeNode search(int n){
        return searchIn(root, n);
    }

    private TreeNode searchIn(TreeNode root, int n){
        if (root == null || n == root.val) return root;
        this.hot = root;
        return searchIn((n > root.val) ? root.right : root.left, n);
    }

    /**
     * 向BST中插入新结点
     * @param n 新结点val
     * @return 插入的新结点
     */
    public TreeNode insert(int n){
        TreeNode x = search(n);
        if (x == null){
            x = new TreeNode(n, hot);
            if (n > hot.val)
                hot.right = x;
            else hot.left = x;
            size++;

        }
        return x;
    }

    /**
     * 删除节点
     * @param n 节点值
     * @return 是否成功
     */
    public boolean remove(int n){
        TreeNode x = search(n);
        if (x == null) return false;
        removeAt(x, hot);
        size--;
        return true;
    }

    private TreeNode removeAt(TreeNode x, TreeNode hot) {
        //实际被删除的节点
        TreeNode w = x;
        //实际被删粗节点的接替者
        TreeNode succ = null;
        //左子树空
        if (x.left == null) succ = x = x.right;
        //右子树空
        else if (x.right == null) succ = x = x.left;
        //左右非空
        else {
            w = w.succ();
            int temp = x.val;
            x.val = w.val;
            w.val = temp;
            TreeNode u = w.parent;
            if (u == x){
                u.right = succ = w.right;
            } else {
                u.left = succ = w.right;
            }
        }
        hot = w.parent;
        if (succ != null) succ.parent = hot;
        return succ;
    }

    /**
     * 查看BST大小
     * @return 节点总数
     */
    public int getSize(){
        return size;
    }

}
