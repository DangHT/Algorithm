package com.dang.leetcode.math;

/**
 * 七进制数(https://leetcode-cn.com/problems/base-7/)
 * @author dht
 * @date 17/09/2019
 */
public class Q_504 {

    public static void main(String[] args) {
        System.out.println(convertToBase7(0));
    }

    public static String convertToBase7(int num) {
        if (num == 0) return "0";
        int temp = num;
        if (num < 0) temp = Math.abs(temp);
        StringBuilder builder = new StringBuilder();
        while (temp > 0) {
            builder.append(temp % 7);
            temp /= 7;
        }
        if (num < 0) builder.append("-");
        return builder.reverse().toString();
    }

}
