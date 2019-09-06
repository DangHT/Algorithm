package com.dang.leetcode.binary;

/**
 * 汉明距离(https://leetcode-cn.com/problems/hamming-distance/)
 * @author dht
 * @date 06/09/2019
 */
public class Q_461 {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1577962638, 1727613287));
    }

    public static int hammingDistance(int x, int y) {
        int[] binX = toBinary(x);
        int[] binY = toBinary(y);
        int count = 0;
        for (int i = 0; i < binX.length; i++) {
            if (binX[i] != binY[i]) count++;
        }
        return count;
    }

    private static int[] toBinary(int x) {
        int[] bin = new int[31];
        int i = 0;
        while (x > 0) {
            bin[i] = x % 2;
            x /= 2;
            i++;
        }
        return bin;
    }

}
