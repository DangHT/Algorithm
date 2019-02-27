package com.dang.nwpu.y2018;

/**
 * 某图像通过一个整数组成的n*n矩阵表示, 其中每个整数表示一个像素值,
 * 写出一种方法, 根据flag变量的值将图像向右或者向左旋转90°,
 * 如果flag值为0, 则想左旋转, 如果flag值为1, 则向右旋转
 * 函数rotatePictureMethod的输入分别由矩阵matrix, 矩阵的维度n
 * 以及flag的值组成, 函数应返回一个指向二维矩阵指针, 该矩阵是按照
 * flag值旋转后的结果矩阵而动态分配的
 * @author dht925nerd@126.com
 * @date 2019/02/27
 */
public class Solution9 {

    /**
     * 原地旋转矩阵
     * @param matrix 矩阵
     * @param flag 方向
     * @return 矩阵
     */
    private static int[][] rotatePictureMethod(int[][] matrix, int flag){
        if (matrix == null || flag < 0 || flag > 1) return null;
        int temp = 0;
        if (flag == 0){
            for (int i = 0; i <= matrix.length / 2; i++){
                for (int j = i; j <= matrix.length / 2 - i; j++){
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][matrix.length - 1 - i];
                    matrix[j][matrix.length - 1 - i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                    matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[matrix.length - 1 - j][i];
                    matrix[matrix.length - 1 - j][i] = temp;
                }
            }
        }
        if (flag == 1){
            for (int i = 0; i <= matrix.length / 2; i++){
                for (int j = i; j <= matrix.length / 2 - i; j++){
                    temp = matrix[i][j];
                    matrix[i][j] =  matrix[matrix.length - 1 - j][i];
                    matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                    matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                    matrix[j][matrix.length - 1 - i] = temp;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotatePictureMethod(matrix, 1);
        for (int[] m : matrix){
            for (int n : m){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

}
