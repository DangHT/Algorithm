package com.dang.leetcode;

import java.util.HashMap;

/**
 * 有效的字母异位词(https://leetcode-cn.com/problems/valid-anagram/)
 * @author dht
 * @date 12/08/2019
 */
public class Q_242 {

    public static void main(String[] args) {
        System.out.println(isAnagram_02("anagram", "nagaram"));
    }

    public static boolean isAnagram_01(String s, String t) {
        if (s == null || t == null) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.replace(c, map.get(c) + 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c))
                return false;
            map.replace(c, map.get(c) - 1);
            if (map.get(c) <= 0)
                map.remove(c);
        }
        return map.size() == 0;
    }

    public static boolean isAnagram_02(String s, String t) {
        if (s == null || t == null) return false;
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            chars[c - 'a']--;
        }
        for (int i : chars)
            if (i != 0) return false;
        return true;
    }

}
