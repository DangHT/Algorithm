package com.dang.leetcode;

/**
 * 反转字符串中的元音字母(https://leetcode-cn.com/problems/reverse-vowels-of-a-string/)
 * @author dht
 * @date 19/08/2019
 */
public class Q_345 {

    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
        if (null == s) return null;
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        char tmp;
        for (;;) {
            while (i < chars.length && !isVowel(chars[i])) i++;
            while (j >= 0 && !isVowel(chars[j])) j--;
            if (i >= j) break;
            if (chars[i] != chars[j]) {
                tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
            }
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c =='A' ||
                c == 'e' || c == 'E' ||
                c == 'i' || c == 'I' ||
                c == 'o' || c == 'O' ||
                c == 'u' || c == 'U';
    }

}
