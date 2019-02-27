package com.dang.nwpu.y2018;

import java.util.Arrays;

/**
 * 在有向图中, 任意指定两个节点分别为起点和终点,
 * 编程查找输出两个节点之间的最短路径
 * @author dht925nerd@126.com
 * @date 2019/02/27
 */
public class Solution7 {

    private static final int ERROR = -1;

    private static void findShortestPath(int[][] map, int from, int to){
        if (map == null || map.length < Math.max(from, to)) return;
        int[] dist = new int[map.length];
        int[] path = new int[map.length];
        if (dijkstra(map, dist, path, from)){
            int temp = to;
            System.out.print("最短路径:");
            while (temp > 0){
                System.out.print(temp + "<-");
                temp = path[temp];
            }
            System.out.println(from);
            System.out.println("总花费:" + dist[to]);
        } else {
            System.out.println("路径不可达!");
        }
    }

    private static boolean dijkstra(int[][] map, int[] dist, int[] path, int start){
        boolean[] collected = new boolean[map.length];
        int v, w;
        for (v = 0; v < map.length; v++){
            dist[v] = map[start][v];
            path[v] = -1;
            collected[v] = false;
        }
        dist[start] = 0;
        collected[start] = true;
        while (true){
            v = findMinDist(map, dist, collected);
            if (v == ERROR) break;
            collected[v] = true;
            for (w = 0; w < map.length; w++){
                if (!collected[w] && map[v][w] < Integer.MAX_VALUE){
                    if (map[v][w] < 0) return false;
                    if (dist[v] + map[v][w] < dist[w]){
                        dist[w] = dist[v] + map[v][w];
                        path[w] = v;
                    }
                }
            }
        }
        return true;
    }

    private static int findMinDist(int[][] map, int[] dist, boolean[] collected){
        int minV = 0, v;
        int minDist = Integer.MAX_VALUE;
        for (v = 0; v < map.length; v++){
            if (!collected[v] && dist[v] < minDist){
                minDist = dist[v];
                minV = v;
            }
        }
        if (minDist < Integer.MAX_VALUE)
            return minV;
        return ERROR;
    }

    public static void main(String[] args) {
        int[][] map = new int[8][8];
        //默认不存在的边为无穷大
        for (int[] m : map){
            Arrays.fill(m, Integer.MAX_VALUE);
        }
        map[1][2] = 2;
        map[1][4] = 1;
        map[2][4] = 3;
        map[2][5] = 10;
        map[3][1] = 4;
        map[3][6] = 5;
        map[4][3] = 2;
        map[4][6] = 8;
        map[4][7] = 4;
        map[4][5] = 2;
        map[5][7] = 6;
        map[7][6] = 1;
        findShortestPath(map, 1, 6);
    }

}
