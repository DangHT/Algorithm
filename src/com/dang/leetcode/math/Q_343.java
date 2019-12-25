package com.dang.leetcode.math;

/**
 * 整数拆分(https://leetcode-cn.com/problems/integer-break/)
 * @author DangHT
 * @date 25/12/2019
 */
public class Q_343 {

    /**
     * 思路：将数字按照2拆分，3拆分...逐次拆分找到最大的乘积和
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n <= 2) return 1;
        if (n <= 3) return 2;
        int res = 1;
        int i = 2, fac = n / i, rem = n % i;
        while(fac > 1) {
            int temp = 1;
            for (int j = 1; j < fac; j++) temp *= i;
            //为保证乘积和最大，对余数为1的情况要加以判断和处理
            temp *= rem < 2 ? i + rem : i * rem;
            if (temp > res) res = temp;
            else break;
            i++;
            fac = n / i;
            rem = n % i;
        }
        return res;
    }

}
