package com.dang.leetcode.math;


/**
 * 平方数之和(https://leetcode-cn.com/problems/sum-of-square-numbers/)
 * @author dht
 * @date 28/10/2019
 */
public class Q_633 {

    public static void main(String[] args) {
        Q_633 q_633 = new Q_633();

        System.out.println(q_633.judgeSquareSum(2));
    }

    public boolean judgeSquareSum(int c) {
        int n = (int) Math.sqrt(c);
        int i = 0, j = n, tmp;
        while (i <= j) {
            tmp = i * i + j * j;
            if (c == tmp) {
                return true;
            }
            else if (c > tmp) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}