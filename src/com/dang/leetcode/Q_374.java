package com.dang.leetcode;


/**
 * 猜数字大小(https://leetcode-cn.com/problems/guess-number-higher-or-lower/)
 * @author dht
 * @date 21/08/2019
 */
public class Q_374 {

    private static final int ANSWER = 9;

    public static void main(String[] args) {
        int answer = guessNumber(10);
        System.out.println("Congratulations! The answer is " + answer);
    }

    public static int guessNumber(int n) {
        int max = Math.max(1, n);
        int min = Math.min(1, n);
        int pick = min + (max - min) / 2;
        while (min < max) {
            switch (guess(pick)) {
                case -1:
                    max = pick;
                    break;
                case 1:
                    min = pick + 1;
                    break;
                default:
                    return pick;
            }
            pick = min + (max - min) / 2;
        }
        return pick;
    }

    private static int guess(int num) {
        return Integer.compare(ANSWER, num);
    }

}