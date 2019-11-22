package com.dang.leetcode.string;

/**
 * 计数二进制子串(https://leetcode-cn.com/problems/count-binary-substrings/)
 * @author dht
 * @date 20/11/2019
 */
public class Q_696 {

    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int c0 = 0, c1 = 0, pre = -1, res = 0;
        for (char c : chars) {
            if ('0' == c) {
                if (1 == pre) c0 = 0;
                pre = 0;
                c0++;
                if (c1 >= c0) res++;
            }
            if ('1' == c) {
                if (0 == pre) c1 = 0;
                pre = 1;
                c1++;
                if (c0 >= c1) res++;
            }
        }
        return res;
    }

}
