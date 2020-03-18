package com.dang.leetcode.string;

/**
 * 拼写单词(https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/)
 * @author DangHT
 * @date 19/03/2020
 */
public class Q_1160 {

    private int[] notes = new int[26];

    public int countCharacters(String[] words, String chars) {
        if (words == null || words.length == 0 || chars == null) return 0;

        int res = 0;
        char[] charArray = chars.toCharArray();
        for (char c : charArray) {
            notes[c - 'a']++;
        }

        for (String word : words) {
            res += check(word);
        }

        return res;
    }

    private int check(String word) {
        char[] chars = word.toCharArray();
        int[] tmpNote = new int[26];

        for (char c : chars) {
            int i = c - 'a';
            tmpNote[i]++;
            if (tmpNote[i] > notes[i]) return 0;
        }

        return chars.length;
    }

}
