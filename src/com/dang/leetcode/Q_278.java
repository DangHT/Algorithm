package com.dang.leetcode;

/**
 * 第一个错误的版本(https://leetcode-cn.com/problems/first-bad-version/)
 * @author dht
 * @date 15/08/2019
 */
public class Q_278 {

    private static boolean[] versions = {false, false, false, true, true};

    public static void main(String[] args) {
        System.out.println(firstBadVersion(versions.length));
    }

    /**
     * 注意：这里求平均值的方法
     *       不可以使用：(left + right) / 2
     *       这样当数值过大时会导致溢出
     *       应使用 left + (right - left) / 2
     * @param n
     * @return
     */
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isBadVersion(int version) {
        return versions[version - 1];
    }

}
