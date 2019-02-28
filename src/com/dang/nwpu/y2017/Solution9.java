package com.dang.nwpu.y2017;

import java.util.Scanner;

/**
 * 编写一个考试成绩统计程序, 将从键盘上输入的学生考试成绩(最多40个)
 * 计算输出学生平均成绩, 以及不及格学生数量(成绩<60分)和成绩优秀
 * 学生数量(成绩>=90分)
 * @author dht925nerd@126.com
 * @date 2019/02/28
 */
public class Solution9 {

    private static void scoreAnalysis(int[] scores){
        if (scores == null || scores.length == 0) return;
        int sum = 0, fail = 0, excellent = 0;
        for (int i : scores){
            if (i < 60) fail++;
            if (i >= 90) excellent++;
            sum += i;
        }
        System.out.println("总人数:" + scores.length);
        System.out.printf("平均分:%.2f\n", (float)sum / scores.length);
        System.out.println("不及格人数:" + fail);
        System.out.println("优秀人数:" + excellent);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] items = in.nextLine().split(" ");
        int[] scores = new int[items.length];
        for (int i = 0; i < scores.length; i++){
            scores[i] = Integer.parseInt(items[i]);
        }
        scoreAnalysis(scores);
    }
}
