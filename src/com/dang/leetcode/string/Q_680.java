package com.dang.leetcode.string;

/**
 * 验证回文字符串 Ⅱ(https://leetcode-cn.com/problems/valid-palindrome-ii/)
 * @author dht
 * @date 13/11/2019
 */
public class Q_680 {

    public static void main(String[] args) {
        Q_680 q_680 = new Q_680();
        String s = "acdcc";
        System.out.println(q_680.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        return valid(chars, 0, chars.length - 1, 0);
    }

    private boolean valid(char[] chars, int from, int to, int count) {
        if (count > 1 || from > to) return false;
        for (int i = from, j = to; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                boolean res = false;
                if (chars[i] == chars[j - 1]) res = valid(chars, i, j - 1, count + 1);
                if (!res && chars[i + 1] == chars[j]) res = valid(chars, i + 1, j, count + 1);
                return res;
            }
        }
        return true;
    }

}
