package com.dang.leetcode.string;

/**
 * 检测大写字母(https://leetcode-cn.com/problems/detect-capital/)
 * @author dht
 * @date 22/09/2019
 */
public class Q_520 {

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("FlaG"));
        System.out.println(detectCapitalUse("Google"));
    }

    public static boolean detectCapitalUse(String word) {
        if (null == word) return true;
        char[] chars = word.toCharArray();
        boolean flag0 = isUpper(chars[0]), flag1 = false;
        if (chars.length > 1) flag1 = isUpper(chars[1]);
        for (int i = 1; i < chars.length; i++) {
            if (!flag0 && isUpper(chars[i])) return false;
            if (flag0 && flag1 && !isUpper(chars[i])) return false;
            if (flag0 && !flag1 && isUpper(chars[i])) return false;
        }
        return true;
    }

    private static boolean isUpper(char c) {
        return 'A' <= c && 'Z' >= c;
    }

}
