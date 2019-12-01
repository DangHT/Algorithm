package com.dang.leetcode.array;

/**
 * 寻找比目标字母大的最小字母(https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/)
 * @author dht
 * @date 29/11/2019
 */
public class Q_744 {

    public char nextGreatestLetter(char[] letters, char target) {
        boolean[] mark = new boolean[26];
        for (char c : letters) {
            mark[c - 'a'] = true;
        }
        int i = target - 'a' + 1;
        while (!mark[i]) i = (i + 1) % 26;
        return (char) ('a' + i);
    }

}
