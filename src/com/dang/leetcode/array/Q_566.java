package com.dang.leetcode.array;

/**
 * 重塑矩阵(https://leetcode-cn.com/problems/reshape-the-matrix/)
 * @author dht
 * @date 27/09/2019
 */
public class Q_566 {

    public static void main(String[] args) {
        Q_566 q_566 = new Q_566();
        int[][] nums = {
                {1, 2},
                {3, 4}
        };
        int[][] res = q_566.matrixReshape(nums, 1, 4);
        for (int[] i : res) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null) return nums;
        if (r * c != nums.length * nums[0].length) return nums;
        int[][] res = new int[r][c];
        int row = 0, col = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (col == c) {
                    row++;
                    col = 0;
                }
                res[row][col] = nums[i][j];
                col++;
            }
        }
        return res;
    }

}
