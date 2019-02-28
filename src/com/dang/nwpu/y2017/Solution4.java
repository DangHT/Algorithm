package com.dang.nwpu.y2017;

/**
 * 编写程序, 从键盘输入一个正整数n, 计算并输出数字n的阶乘n!
 * @author dht925nerd@126.com
 * @date 2019/02/28
 */
public class Solution4 {

    private static long factorial(int n){
        if (n == 0) return 0;
        long result = 1;
        for (int i = 1; i <= n; i++){
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++){
            System.out.println(i + ":" + factorial(i));
        }
    }

}
