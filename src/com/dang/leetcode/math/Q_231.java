package com.dang.leetcode.math;

/**
 * 2的幂 (https://leetcode-cn.com/problems/power-of-two/)
 * @author dht
 * @date 27/07/2019
 */
public class Q_231 {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(218));
    }

    /**
     * 我的答案，迭代验证法
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n > 0) {
            if (n == 1) return true;
            if (n % 2 == 1) return false;
            n /= 2;
        }
        return true;
    }

    /**
     * 位运算法
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo_bit(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
