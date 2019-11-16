package com.dang.leetcode.string;

/**
 * 重复叠加字符串匹配(https://leetcode-cn.com/problems/repeated-string-match/)
 * @author dht
 * @date 14/11/2019
 */
public class Q_686 {

    public static void main(String[] args) {
        Q_686 q_686 = new Q_686();
        String a = "aabaa";
        String b = "aaab";
        System.out.println(q_686.repeatedStringMatch(a, b));
    }

    public int repeatedStringMatch(String A, String B) {
        char[] text = A.toCharArray();
        char[] pattern = B.toCharArray();
        for (int i = 0; i < text.length; i++) {
            int count = 1;
            if (text[i] == pattern[0]) {
                int j = 1, k = (i + 1) % text.length;
                boolean done = true;
                while (j < pattern.length) {
                    if (k == 0) count++;
                    if (pattern[j] != text[k]) {
                        done = false;
                        break;
                    }
                    j++;
                    k = (k + 1) % text.length;
                }
                if (done) return count;
            }
        }
        return -1;
    }

    public int repeatedStringMatch_sb(String A, String B) {
        int times = (B.length() - 1) / A.length() + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(A);
        }
        if (sb.lastIndexOf(B) > -1){
            return times;
        }
        sb.append(A);
        if (sb.lastIndexOf(B) > -1){
            return times + 1;
        }
        return -1;
    }

}
