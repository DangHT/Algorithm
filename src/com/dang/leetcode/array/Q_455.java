package com.dang.leetcode.array;

import java.util.Arrays;

/**
 * 分发饼干(https://leetcode-cn.com/problems/assign-cookies/)
 * @author dht
 * @date 05/09/2019
 */
public class Q_455 {

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) return 0;
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++;
                i++;
            }
            j++;
        }
        return count;
    }

}
