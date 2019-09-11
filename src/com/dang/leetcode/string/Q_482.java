package com.dang.leetcode.string;

/**
 * 密钥格式化(https://leetcode-cn.com/problems/license-key-formatting/)
 * @author dht
 * @date 11/09/2019
 */
public class Q_482 {

    public static void main(String[] args) {
        String S = "r";
        int K = 2;
        System.out.println(licenseKeyFormatting(S, K));
    }

    public static String licenseKeyFormatting(String S, int K) {
        char[] chars = S.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '-')
                count++;
            if ('a' <= chars[i] && chars[i] <= 'z')
                chars[i] -= 32;
        }
        int pos = count % K, index = 0;
        count = 0;
        StringBuilder builder = new StringBuilder();
        if (pos > 0) {
            while (count < pos) {
                if (chars[index] == '-') {
                    index++;
                    continue;
                }
                builder.append(chars[index]);
                index++;
                count++;
            }
            count = 0;
            if (index < chars.length) builder.append('-');
        }
        while (index < chars.length) {
            if (chars[index] == '-') {
                index++;
                continue;
            }
            if (count == K) {
                builder.append('-');
                count = 0;
            }
            builder.append(chars[index]);
            index++;
            count++;
        }
        return builder.toString();
    }

}
