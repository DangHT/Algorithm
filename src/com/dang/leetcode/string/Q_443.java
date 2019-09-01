package com.dang.leetcode.string;

/**
 * 压缩字符串(https://leetcode-cn.com/problems/string-compression/)
 * @author dht
 * @date 29/08/2019
 */
public class Q_443 {

    public static void main(String[] args) {
        String s = "abbbbbbbbbbbb";
        char[] chars = s.toCharArray();
        int len = compress(chars);
        for (int i = 0; i < len; i++) {
            System.out.print(chars[i] + " ");
        }
    }

    public static int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;
        if (chars.length == 1) return 1;
        int count = 0, result = 1, pos = 0;
        char current = chars[0];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != current) {
                if (count > 1) {
                    pos += replace(chars, pos, count);
                }
                count = 1;
                chars[++pos] = chars[i];
                current = chars[i];
            } else {
                count++;
            }
        }
        if (count > 1) {
            pos += replace(chars, pos, count);
        }
        return pos + 1;
    }

    private static int replace(char[] chars, int pos, int count) {
        int len = 0, tmp = count;
        while (tmp > 0) {
            len++;
            tmp /= 10;
        }
        for (int i = pos + len; i > pos; i--) {
            chars[i] = (char) ('0' + count % 10);
            count /= 10;
        }
        return len;
    }

}
