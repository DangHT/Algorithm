package com.dang.leetcode.string;

/**
 * 重复的子字符串(https://leetcode-cn.com/problems/repeated-substring-pattern/)
 * @author dht
 * @date 05/09/2019
 */
public class Q_459 {

    public static void main(String[] args) {
        String s = "abcabcabcc";
        System.out.println(repeatedSubstringPattern_01(s));
    }

    public static boolean repeatedSubstringPattern_01(String s) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars.length % i == 0) {
                if (check(chars, i)) return true;
            }
        }
        return false;
    }

    private static boolean check(char[] chars, int len) {
        int count = chars.length / len;
        for (int i = 1; i < count; i++) {
            for (int j = i * len, n = 0; n < len; n++) {
                if (chars[n] != chars[j + n]) return false;
            }
        }
        return true;
    }

    public static boolean repeatedSubstringPattern_02(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return false;
        }
        char lastc = s.charAt(len - 1);
        int l = s.lastIndexOf(lastc, len / 2 - 1) + 1;
        for (; l > 0; l = s.lastIndexOf(lastc, l - 2) + 1) {
            if (len % l == 0) {
                String p = s.substring(0, l);
                boolean res = true;
                for (int i = l; i < len; i += l) {
                    if (!s.substring(i, i + l).equals(p)) {
                        res = false;
                        break;
                    }
                }
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

}
