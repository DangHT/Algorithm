package com.dang.leetcode.string;

/**
 * 判断子序列（https://leetcode-cn.com/problems/is-subsequence/）
 * @author DangHT
 * @date 2020/07/06
 */
public class Q_392 {

    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        if (t == null || t.length() == 0) return false;
        int i = 0, j = 0;
        int lenS = s.length(), lenT = t.length();
        while (j < lenT) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                if (i == lenS) return true;
            }
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        Q_392 q_392 = new Q_392();
        System.out.println(q_392.isSubsequence("acb", "ahbgdc"));
    }

}
