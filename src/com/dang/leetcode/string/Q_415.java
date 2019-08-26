package com.dang.leetcode.string;

/**
 * 字符串相加(https://leetcode-cn.com/problems/add-strings/)
 * @author dht
 * @date 26/08/2019
 */
public class Q_415 {

    public static void main(String[] args) {
        String num1 = "9";
        String num2 = "99";
        System.out.println(addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2) {
        if (null == num1 && null == num2) return null;
        if (null == num1) return num2;
        if (null == num2) return num1;

        char[] c1 = num1.length() > num2.length() ? num1.toCharArray() : num2.toCharArray();
        char[] c2 = num1.length() > num2.length() ? num2.toCharArray() : num1.toCharArray();
        boolean carry = false;
        int i = c1.length - 1, j = c2.length - 1, sum = 0;
        while (j >= 0) {
            sum = charToInt(c1[i]) + charToInt(c2[j]);
            if (carry) sum++;
            carry = sum > 9;
            c1[i] = intToChar(sum % 10);
            i--;
            j--;
        }
        while (i >= 0) {
            if (!carry) break;
            sum = charToInt(c1[i]) + 1;
            carry = sum > 9;
            c1[i] = intToChar(sum % 10);
            i--;
        }

        StringBuilder builder = new StringBuilder();
        if (carry) builder.append(1);
        builder.append(c1);

        return builder.toString();
    }

    private static int charToInt(char c) {
        return c - '0';
    }

    private static char intToChar(int i) {
        return (char) ('0' + i);
    }

}
