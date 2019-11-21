package com.dang.leetcode.math;

/**
 * 交替位二进制数(https://leetcode-cn.com/problems/binary-number-with-alternating-bits/)
 * @author dht
 * @date 20/11/2019
 */
public class Q_693 {

    public boolean hasAlternatingBits(int n) {
        int pre = n % 2;
        n /= 2;
        while (n > 0) {
            int tmp = n % 2;
            if (pre == tmp) return false;
            pre = tmp;
            n /= 2;
        }
        return true;
    }

}
