package com.dang.nwpu.y2017;

/**
 * 编写程序, 从文件中读入两组整数(2*9个数字), 分别构造两个3*3维矩阵,
 * 最后计算和输出这两个3*3矩阵的乘积
 * @author dht925nerd@126.com
 * @date 2019/02/28
 */
public class Solution3 {

    private static void matrixProduct(int[][] mA, int[][] mB){
        if (mA == null || mB == null) return;
        for (int i = 0; i < mA.length; i++){
            for (int j = 0; j < mA[i].length; j++){
                mA[i][j] *= mB[i][j];
            }
        }
        for (int[] m : mA){
            for (int i : m){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mA = {
                {1, 3, 2},
                {1, 0, 0},
                {1, 2, 2}
        };
        int[][] mB = {
                {0, 0, 2},
                {7, 5, 0},
                {2, 1, 1}
        };
        matrixProduct(mA, mB);
    }

}
