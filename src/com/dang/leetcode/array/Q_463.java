package com.dang.leetcode.array;

/**
 * 岛屿的周长(https://leetcode-cn.com/problems/island-perimeter/)
 * @author dht
 * @date 06/09/2019
 */
public class Q_463 {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 1, 0}
        };
        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        if (grid == null) return 0;
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += check(grid, i, j);
                }
            }
        }
        return perimeter;
    }

    private static int check(int[][] grid, int i, int j) {
        int count = 0;
        if (i == 0) count++;
        if (i == grid.length - 1) count++;
        if (j == 0) count++;
        if (j == grid[i].length - 1) count++;
        if (i == 0) {
            if (j > 0 && grid[i][j - 1] == 0) count++;
            if (j < grid[i].length - 1 && grid[i][j + 1] == 0) count++;
            if (i < grid.length - 1 && grid[i + 1][j] == 0) count++;
        } else if (i == grid.length - 1) {
            if (j > 0 && grid[i][j - 1] == 0) count++;
            if (j < grid[i].length - 1 && grid[i][j + 1] == 0) count++;
            if (i > 0 && grid[i - 1][j] == 0) count++;
        } else {
            if (j > 0 && grid[i][j - 1] == 0) count++;
            if (j < grid[i].length - 1 && grid[i][j + 1] == 0) count++;
            if (i < grid.length - 1 && grid[i + 1][j] == 0) count++;
            if (i > 0 && grid[i - 1][j] == 0) count++;
        }
        return count;
    }

}
