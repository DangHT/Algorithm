package com.dang.leetcode.array;

/**
 * 种花问题(https://leetcode-cn.com/problems/can-place-flowers/)
 * @author dht
 * @date 26/10/2019
 */
public class Q_605 {

    public static void main(String[] args) {
        Q_605 q_605 = new Q_605();
        int[] flowerbed = {1, 0, 0, 0, 0, 1};
        System.out.println(q_605.canPlaceFlowers(flowerbed, 2));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (0 == n) return true;
        int countNone = 0, i = 0;
        while (i < flowerbed.length) {
            if (0 == flowerbed[i]) {
                countNone = 1;
                int j = i + 1;
                while (j < flowerbed.length && flowerbed[j] == 0) {
                    countNone++;
                    j++;
                }
                if (0 == i) {
                    n -= flowerbed.length == countNone ? (flowerbed.length + 1) / 2 : countNone / 2;
                } else {
                    n -= flowerbed.length == i + countNone ? countNone / 2 : (countNone - 1) / 2;
                }
                if (n <= 0) return true;
                i = j - 1;
            }
            i++;
        }
        return false;
    }

}
