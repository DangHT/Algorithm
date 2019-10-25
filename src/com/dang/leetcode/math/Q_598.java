package com.dang.leetcode.math;

/**
 * 范围求和 II(https://leetcode-cn.com/problems/range-addition-ii/)
 * @author dht
 * @date 23/10/2019
 */
public class Q_598 {

    public int maxCount(int m, int n, int[][] ops) {
        int minLen = m;
        int minWid = n;
        for (int[] op : ops) {
            if (minLen > op[0]) minLen = op[0];
            if (minWid > op[1]) minWid = op[1];
        }
        return minLen * minWid;
    }

}
