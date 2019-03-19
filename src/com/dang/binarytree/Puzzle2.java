package com.dang.binarytree;

/**
 * 请把一段纸条竖放在桌子上，然后从纸条的下边向上方对折1次，
 * 压出折痕后展开，此时折痕是凹下去的，即折痕突起的方向指向
 * 纸条的背面，如果从纸条的下边向上方连续对折2次，压出折痕后
 * 展开，此时有三条折痕，从上到下依次是下折痕，下折痕和上折痕，
 * 给定一个输入参数N，代表纸条都从下边向上方连续对折N次，请从
 * 上到下打印所有折痕的方向
 *
 * 第一次：          _下_
 *                /     \
 * 第二次：       上      下
 *              / \     / \
 * 第三次：     上  下   上  下
 *
 * @author dht925nerd@126.com
 * @date 2019/03/19
 */
public class Puzzle2 {

    /**
     * 定义：上 = 1， 下 = 0
     * 1. 先建树，根节点为0，每个节点的左节点是1，右节点是0
     * 2. 中序遍历，输出结果
     * @param N 对折 N 次
     */
    private static void solution(int N){
        if (N <= 0) return;
        TreeNode root = new TreeNode(0);
        build(root, N);
        Traversal.inOrder(root);
    }

    private static void build(TreeNode root, int N){
        if (root == null || N == 1) return;
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        build(root.left, N - 1);
        build(root.right, N - 1);
    }

    public static void main(String[] args) {
        for (int i = 1; i < 6; i++){
            solution(i);
            System.out.println();
        }
    }

}
