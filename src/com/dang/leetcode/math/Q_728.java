package com.dang.leetcode.math;

import java.util.LinkedList;
import java.util.List;

/**
 * 自除数(https://leetcode-cn.com/problems/self-dividing-numbers/)
 * @author dht
 * @date 26/11/2019
 */
public class Q_728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (isDividingNumber(i)) res.add(i);
        }
        return res;
    }

    private boolean isDividingNumber(int num) {
        int tmp = num;
        while (tmp > 0) {
            int t = tmp % 10;
            if (t == 0 || num % t != 0) return false;
            tmp /= 10;
        }
        return true;
    }

}
