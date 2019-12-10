package com.dang.leetcode.math;

/**
 * 二进制表示中质数个计算置位(https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/)
 * @author dht
 * @date 09/12/2019
 */
public class Q_762 {

    public static void main(String[] args) {
        Q_762 q_762 = new Q_762();
        System.out.println(q_762.countPrimeSetBits(10, 15));
    }

    public int countPrimeSetBits(int L, int R) {
        boolean[] prime = {
                false, false, true, true,
                false, true, false, true,
                false, false, false, true,
                false, true, false, false,
                false, true, false, true
        };
        boolean[] bits = new boolean[20];
        int count = 0, left = L, right = R, res = 0;
        for (int i = 0; left > 0; i++, left /= 2) {
            if (left % 2 == 1) {
                bits[i] = true;
                count++;
            }
        }
        if (prime[count]) res++;
        for (int i = L; i < R; i++) {
            for (int j = 0; j < bits.length; j++) {
                if (bits[j]) {
                    bits[j] = false;
                    count--;
                } else {
                    bits[j] = true;
                    count++;
                    break;
                }
            }
            if (prime[count]) res++;
        }
        return res;
    }

}
