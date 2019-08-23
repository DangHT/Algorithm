package com.dang.leetcode.string;

/**
 * 找不同(https://leetcode-cn.com/problems/find-the-difference/)
 * @author dht
 * @date 23/08/2019
 */
public class Q_389 {

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s, t));
    }

    public static char findTheDifference(String s, String t) {
        int count = 0;
        for (char c : t.toCharArray()) {
            count += c;
        }
        for (char c : s.toCharArray()) {
            count -= c;
        }
        return (char) count;
    }

}
