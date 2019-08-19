package com.dang.leetcode;

/**
 * 4的幂(https://leetcode-cn.com/problems/power-of-four/)
 * @author dht
 * @date 19/08/2019
 */
public class Q_342 {

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(5));
    }

    public static boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        while (num > 1) {
            if (num % 4 != 0) {
                return false;
            }
            num /= 4;
        }
        return true;
    }

}
