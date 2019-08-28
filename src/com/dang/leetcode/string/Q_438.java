package com.dang.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到字符串中所有字母异位词(https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/)
 * @author dht
 * @date 28/08/2019
 */
public class Q_438 {

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> results = findAnagrams_01(s, p);
        for (int i : results) {
            System.out.print(i + " ");
        }
    }

    /**
     * 记录p中的字母数，
     * 设置p.length()长度的滑动窗口从s首字母开始滑动
     * 每一次滑动记录字母数并检查字母数是否相等
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams_01(String s, String p) {
        List<Integer> results = new ArrayList<>();
        if (null == s || s.length() < p.length()) return results;

        int[] words = new int[26];
        for (int i = 0; i < p.length(); i++) {
            words[p.charAt(i) - 'a']++;
        }
        int[] current = new int[26];
        for (int i = 0; i < p.length(); i++) {
            current[s.charAt(i) - 'a']++;
        }

        for (int i = p.length(); i < s.length(); i++) {
            if (check(words, current)) {
                results.add(i - p.length());
            }
            current[s.charAt(i - p.length()) - 'a']--;
            current[s.charAt(i) - 'a']++;
        }
        if (check(words, current)) {
            results.add(s.length() - p.length());
        }

        return results;
    }

    private static boolean check(int[] words, int[] current) {
        for (int i = 0; i < words.length; i++) {
            if (words[i] != current[i])
                return false;
        }
        return true;
    }

    /**
     * 优化检查字母数相等的过程
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams_02(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] p_letter = new int[26];
        for (int i = 0; i < p.length(); i++) {
            p_letter[p.charAt(i) - 'a']++;
        }
        int start = 0;
        int end = 0;
        int[] between_letter = new int[26];
        while (end < s.length()) {
            int c = s.charAt(end++) - 'a';
            between_letter[c]++;

            /*
             若出现当前记录的s某个字母数大于p中的字母时
             一直移动start直到字母数相等，
             因为在这之间的字符串必然不会匹配
             */
            while (between_letter[c] > p_letter[c]) {
                between_letter[s.charAt(start++) - 'a']--;
            }
            if (end - start == p.length()) {
                result.add(start);
            }
        }
        return result;
    }

}
