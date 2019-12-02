package com.dang.leetcode.dp;

/**
 * 使用最小花费爬楼梯(https://leetcode-cn.com/problems/min-cost-climbing-stairs/)
 * @author dht
 * @date 29/11/2019
 */
public class Q_746 {

    private int[] dp;

    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        return Math.min(climb(cost, 0), climb(cost, 1));
    }

    private int climb(int[] cost, int i) {
        if (i + 2 >= cost.length) {
            return i < cost.length ? cost[i] : 0;
        }
        if (dp[i] == 0) {
            dp[i] = cost[i] + Math.min(climb(cost, i + 1), climb(cost, i + 2));
        }
        return dp[i];
    }

}
