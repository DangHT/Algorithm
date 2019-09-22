package com.dang.leetcode.math;

/**
 * 斐波那契数(https://leetcode-cn.com/problems/fibonacci-number/)
 * @author dht
 * @date 21/09/2019
 */
public class Q_509 {

    private static int[] notes = new int[30];

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(fib(i));
        }
    }

    public static int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        if (0 == notes[N - 1]) notes[N - 1] = fib(N - 1);
        if (0 == notes[N - 2]) notes[N - 2] = fib(N - 2);
        return notes[N - 1] + notes[N - 2];
    }

}
