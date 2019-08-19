package com.dang.leetcode;

/**
 * 反转字符串(https://leetcode-cn.com/problems/reverse-string/)
 * @author dht
 * @date 19/08/2019
 */
public class Q_344 {

    public static void main(String[] args) {
        char[] s = {'H', 'a', 'n', 'n', 'A', 'a', 'h'};
        reverseString(s);
        for (char c : s) {
            System.out.print(c + " ");
        }
    }

    public static void reverseString(char[] s) {
        char tmp;
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            if (s[i] != s[j]) {
                tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
            }
        }
    }

}
