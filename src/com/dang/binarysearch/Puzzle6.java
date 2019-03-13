package com.dang.binarysearch;

/**
 * 如何更快地求一个整数k的N次方, 如果两个整数
 * 相乘并得到结果的时间复杂度为O(1), 得到整数
 * k的N次方的过程请实现时间复杂度为O(logN)的方法
 * @author dht925nerd@126.com
 * @date 2019/03/13
 */
public class Puzzle6 {

    private static long solution(int k, int N){
        if (N == 0 || k == 1) return 1;
        if (N == 1) return k;
        if (k == 0) return 0;
        long res = 1;
        StringBuilder builder = new StringBuilder();
        char[] bin = toBinary(N, builder).toCharArray();
        long[] note = new long[bin.length];
        note[0] = k;
        for (int i = 1; i < note.length; i++){
            note[i] = (long) Math.pow(note[i - 1], 2);
        }
        for (int i = 0; i < bin.length; i++){
            if (bin[i] == '1'){
                res *= note[i];
            }
        }
        return res;
    }

    private static String toBinary(int N, StringBuilder builder){
        if (N == 0 || builder == null) return null;
        builder.append(N % 2);
        toBinary(N / 2, builder);
        return builder.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++){
            System.out.println(solution(9, i));
        }
    }

}
