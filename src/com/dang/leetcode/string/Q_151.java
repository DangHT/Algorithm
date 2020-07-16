package com.dang.leetcode.string;

/**
 * 翻转字符串里的单词(https://leetcode-cn.com/problems/reverse-words-in-a-string/)
 * @author DangHT
 * @date 2020/07/16
 */
public class Q_151 {

    public String reverseWords(String s) {
        if (s == null) return "";
        s = s.trim();
        if (s.length() == 0) return "";

        String[] words = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() > 0) {
                builder.append(words[i]);
                builder.append(" ");
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public static void main(String[] args) {
        Q_151 q_151 = new Q_151();
        System.out.println("\"" + q_151.reverseWords("  hello world!  ") + "\"");
    }

}
