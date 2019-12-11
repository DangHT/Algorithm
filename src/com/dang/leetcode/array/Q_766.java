package com.dang.leetcode.array;

/**
 * 托普利茨矩阵(https://leetcode-cn.com/problems/toeplitz-matrix/)
 * @author dht
 * @date 09/12/2019
 */
public class Q_766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i - 1][j - 1] != matrix[i][j]) return false;
            }
        }
        return true;
    }

}
