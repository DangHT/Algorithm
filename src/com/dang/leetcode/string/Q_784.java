package com.dang.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 字母大小写全排列(https://leetcode-cn.com/problems/letter-case-permutation/)
 * @author DangHT
 * @date 30/12/2019
 */
public class Q_784 {

    public static void main(String[] args) {
        Q_784 q_784 = new Q_784();
        List<String> res = q_784.letterCasePermutation("1a2b3c4");
        for (String s : res) {
            System.out.println(s);
        }
    }

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        res.add(S);
        int letterCount = 0;
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ('a' <= chars[i] && 'z' >= chars[i] ||
                'A' <= chars[i] && 'Z' >= chars[i])
                letterCount++;
        }
        for (int i = 1; i <= letterCount; i++) {
            change(res, S.toCharArray(), 0, i);
        }
        return res;
    }

    private void change(List<String> res, char[] chars, int index, int count) {
        for (int i = index; chars.length - i >= count; i++) {
            if ('a' <= chars[i] && 'z' >= chars[i]) {
                // 'a' - 'A' == 32
                chars[i] -= 32;
                if (0 == count - 1) res.add(String.copyValueOf(chars));
                else change(res, chars, i + 1, count - 1);
                chars[i] += 32;
            } else if ('A' <= chars[i] && 'Z' >= chars[i]) {
                chars[i] += 32;
                if (0 == count - 1) res.add(String.copyValueOf(chars));
                else change(res, chars, i + 1, count - 1);
                chars[i] -= 32;
            }
        }
    }

}
