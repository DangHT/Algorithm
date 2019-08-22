package com.dang.leetcode.string;

/**
 * 字符串中的第一个唯一字符(https://leetcode-cn.com/problems/first-unique-character-in-a-string/)
 *
 * @author dht
 * @date 22/08/2019
 */
public class Q_387 {

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar_01(s));
    }

    public static int firstUniqChar_01(String s) {
        if (null == s || s.length() == 0) return -1;
        if (s.length() == 1) return 0;
        int[] wordsCount = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            wordsCount[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (wordsCount[chars[i] - 'a'] == 1)
                return i;
        }
        return -1;
    }

    public static int firstUniqChar_02(String s) {
        int index = -1;
        for (char i = 'a'; i <= 'z'; i++) {
            int startindex = s.indexOf(i);
            if (startindex != -1 && startindex == s.lastIndexOf(i)) {
                index = (index == -1 || index > startindex) ? startindex : index;
            }
        }
        return index;
    }

}
