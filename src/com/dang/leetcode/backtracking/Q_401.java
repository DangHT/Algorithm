package com.dang.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表(https://leetcode-cn.com/problems/binary-watch/)
 * @author dht
 * @date 25/08/2019
 */
public class Q_401 {

    public static void main(String[] args) {
        List<String> results = readBinaryWatch_01(8);
        for (String s : results) {
            System.out.println(s);
        }
    }

    /**
     * Solution1:
     * DFS + 回溯 + 剪枝
     * @param num
     * @return
     */
    public static List<String> readBinaryWatch_01(int num) {
        List<String> results = new ArrayList<>();
        int[] time = {8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
        boolean[] visited = new boolean[10];
        track(visited, num, time, results);
        return results;
    }

    /**
     * DFS过程
     * @param visited
     * @param num
     * @param time
     * @param results
     */
    private static void track(boolean[] visited, int num, int[] time, List<String> results) {
        if (null == visited || visited.length != 10) return;
        if (num == 0) {
            String s = read(visited, time);
            if (s != null)results.add(s);
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = !visited[i];
                //剪枝
                if (!results.contains(read(visited, time))) track(visited, num - 1, time, results);
                visited[i] = !visited[i];
            }
        }
    }

    /**
     * 读表
     * @param visited
     * @param time
     * @return
     */
    private static String read(boolean[] visited, int[] time) {
        if (null == visited || visited.length != 10) return null;
        StringBuilder builder = new StringBuilder();
        int hour = 0, minute = 0;
        for (int i = 4; i < 10; i++) {
            if (visited[i]) {
                minute += time[i];
                if (minute >= 60) return null;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (visited[i]){
                hour += time[i];
                if (hour >= 12) return null;
            }
        }
        builder.append(hour).append(":").append(minute > 9 ? minute : "0" + minute);
        return builder.toString();
    }

    /**
     * Solution2:
     * 题中给出时间有范围限制，利用这一点，遍历所有的时间，找出每个时间中含1的个数
     * 思路新奇！
     * @param num
     * @return
     */
    public List<String> readBinaryWatch(int num) {
        List<String> resList = new ArrayList<>();
        for (int i = 0; i < 12; ++i)
            for (int j = 0; j < 60; ++j)
                if (Integer.bitCount((i << 6) | j) == num)
                    resList.add(i + ":" + (j > 9 ? "" : "0") + j);
        return resList;
    }

    /**
     * 计算二进制中1的个数
     * @param n
     * @return
     */
    int count1(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

}
