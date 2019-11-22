package com.dang.string;

import com.dang.binarytree.Serialize;
import com.dang.binarytree.TreeNode;

/**
 * <p>给定彼此独立的两棵头节点分别为t1和t2, 判断t1中是否有与t2树拓扑结构完全相同的子树</p>
 * <p>例如, 下图所示的t1和t2:</p>
 *       __1__             2
 *      /     \           / \
 *     2      3          4   5
 *    / \    / \        /     \
 *   4   5  6   7      8       9
 *  /     \
 * 8       9
 *        t1树            t2树
 * <p>t1树含有与t2树拓扑结构完全相同的子树, 所以返回:true</p>
 * <p>但如果t1与t2树如下图所示:</p>
 *       __1__             2
 *      /     \           / \
 *     2      3          4   5
 *    / \    / \        /
 *   4   5  6   7      8
 *  /     \
 * 8       9
 *        t1树            t2树
 * 则返回:false
 * @author dht925nerd@126.com
 * @date 2019/03/02
 */
public class Puzzle1 {

    /**
     * <p>二叉树遍历 + 匹配问题</p>
     * 考察t1中以每个节点为头的子树是否与t2一致
     * @param t1 t1
     * @param t2 t2
     * @return answer
     */
    private static boolean solution1(TreeNode t1, TreeNode t2){
        if (t1 == null || t2 == null) return false;
        if (t1.val == t2.val){
            return isSame(t1, t2);
        }
        return solution1(t1.left, t2) || solution1(t1.right, t2);
    }

    /**
     * 查看两棵树是否同构
     * @param t1 t1
     * @param t2 t2
     * @return answer
     */
    private static boolean isSame(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null) return true;
        if (t1 != null && t2 != null)
            return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
        return false;
    }

    /**
     * <p>最优解:二叉树序列化 + KMP算法</p>
     * 时间复杂度:O(M+N)
     *
     *   二叉树t1           二叉树t2
     *     |(序列化)          |(序列化)
     *  字符串str1         字符串str2
     *     \                /
     *   用KMP算法判断str1中是否有str2
     *             |
     *  如果包含说明含有同构子树返回:true
     *        否则返回:false
     *
     * @param t1 t1
     * @param t2 t2
     * @return answer
     */
    public static boolean solution2(TreeNode t1, TreeNode t2){
        String str1 = Serialize.preOrderSerialize(t1);
        String str2 = Serialize.preOrderSerialize(t2);
        return KMP.hasSub(str2, str1);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.right.left = new TreeNode(6);
        t1.right.right = new TreeNode(7);
        t1.left.left.left = new TreeNode(8);
        t1.left.right.right = new TreeNode(9);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(4);
        t2.right = new TreeNode(5);
        t2.left.left = new TreeNode(8);
        t2.right.right = new TreeNode(9);
        System.out.println(solution2(t1, t2));
    }

}
