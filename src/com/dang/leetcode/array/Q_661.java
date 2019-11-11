package com.dang.leetcode.array;

/**
 * 图片平滑器(https://leetcode-cn.com/problems/image-smoother/)
 * @author dht
 * @date 10/11/2019
 */
public class Q_661 {

    public int[][] imageSmoother(int[][] M) {
        int[][] smoothed = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                smoothed[i][j] = doSmooth(M, i, j);
            }
        }
        return smoothed;
    }

    private int doSmooth(int[][] M, int i, int j) {
        int sum = 0, count = 0;
        for (int m = i - 1; m <= i + 1; m++) {
            if (m >= 0 && m < M.length) {
                for (int n = j - 1; n <= j + 1; n++) {
                    if (n >= 0 && n < M[0].length) {
                        sum += M[m][n];
                        count++;
                    }
                }
            }
        }
        return sum / count;
    }

}
