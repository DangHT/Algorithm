package com.dang.leetcode.string;

/**
 * 反转字符串 II(https://leetcode-cn.com/problems/reverse-string-ii/)
 * @author dht
 * @date 24/09/2019
 */
public class Q_541 {

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseStr(s, 8));
    }

    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int from = 0, to = from + k - 1;
        while (to < chars.length) {
            reverse(chars, from, to);
            from = to + k + 1;
            to = from + k - 1;
        }
        if (from < chars.length) {
            reverse(chars, from, chars.length - 1);
        }
        return String.valueOf(chars);
    }

    private static void reverse(char[] chars, int from, int to) {
        if (from < 0 || to > chars.length) return;
        char temp;
        while (from < to) {
            temp = chars[from];
            chars[from] = chars[to];
            chars[to] = temp;
            from++;
            to--;
        }
    }

}