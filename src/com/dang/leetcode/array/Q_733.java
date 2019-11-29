package com.dang.leetcode.array;

/**
 * 图像渲染(https://leetcode-cn.com/problems/flood-fill/)
 * @author dht
 * @date 27/11/2019
 */
public class Q_733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int old = image[sr][sc];
        // 只修改颜色相同的位置，因此如果初始位置颜色与newColor一样就不用再修改了
        if (old != newColor) dfs(image, sr, sc, old, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int old, int newColor) {
        if (image[sr][sc] == old) {
            image[sr][sc] = newColor;
            if (sr + 1 < image.length) dfs(image, sr + 1, sc, old, newColor);
            if (sr - 1 > -1) dfs(image, sr - 1, sc, old, newColor);
            if (sc + 1 < image[0].length) dfs(image, sr, sc + 1, old, newColor);
            if (sc - 1 > -1) dfs(image, sr, sc - 1, old, newColor);
        }
    }

}
