package com.dang.leetcode;

import java.util.HashMap;

/**
 * 单词规律(https://leetcode-cn.com/problems/word-pattern/)
 * @author dht
 * @date 17/08/2019
 */
public class Q_290 {

    public static void main(String[] args) {
        String pattern = "aaaa";
        String str = "cat cat cat cat";
        System.out.println(wordPattern(pattern, str));
    }

    public static boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0
                || str == null || str.length() == 0) return false;
        char[] patternChar = pattern.toCharArray();
        String[] strings = str.split(" ");
        if (patternChar.length != strings.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < patternChar.length; i++) {
            if (!map.containsKey(patternChar[i])) {
                if (map.containsValue(strings[i])) return false;
                map.put(patternChar[i], strings[i]);
            } else {
                if (!map.get(patternChar[i]).equals(strings[i]))
                    return false;
            }
        }
        return true;
    }

}
