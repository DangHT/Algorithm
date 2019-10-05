package com.dang.leetcode.array;

import java.util.Arrays;

/**
 * 分糖果(https://leetcode-cn.com/problems/distribute-candies/)
 * @author dht
 * @date 28/09/2019
 */
public class Q_575 {

    public static void main(String[] args) {
        Q_575 q_575 = new Q_575();
        int[] candies = {1, 1, 2, 2, 3, 3};
        System.out.println(q_575.distributeCandies(candies));
    }

    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        int types = 1, cur = candies[0];
        for (int i : candies) {
            if (cur != i) {
                types++;
                cur = i;
            }
        }
        return Math.min(candies.length / 2, types);
    }

}
