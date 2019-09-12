package com.dang.leetcode.math;

/**
 * 构造矩形(https://leetcode-cn.com/problems/construct-the-rectangle/)
 * @author dht
 * @date 11/09/2019
 */
public class Q_492 {

    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            int[] res = constructRectangle(i);
            System.out.print(i + ": ");
            for (int j : res) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static int[] constructRectangle(int area) {
        int L, M;
        L = (int) Math.sqrt(area);
        while (L <= area) {
            if (area % L == 0) break;
            L++;
        }
        M = area / L;
        int[] res = {Math.max(L, M), Math.min(L, M)};
        return res;
    }

}
