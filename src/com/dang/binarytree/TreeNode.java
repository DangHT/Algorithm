package com.dang.binarytree;

/**
 * 二叉树节点
 * @author dht925nerd@126.com
 * @date 2019/02/25
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode parent){
        this.val = val;
        this.parent = parent;
    }

    /**
     * 中序遍历前继
     * @return 前继节点
     */
    public TreeNode succ(){
        if (this.right == null) return this;
        TreeNode temp = this.right.left;
        while (temp.left != null){
            temp = temp.left;
        }
        return temp;
    }

}
