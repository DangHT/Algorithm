package com.dang.nwpu.y2017;

import java.util.Scanner;

/**
 * 请编写程序, 将用户输入的一个字符串(不多于100个字符),
 * 其中的单词按照逆序, 重新输出, 例如输入字符串“this is a dog”,
 * 输出"dog a is this"
 * @author dht925nerd@126.com
 * @date 2019/02/28
 */
public class Solution8 {

    private static String reverseString(String s){
        if (s == null) return null;
        String[] strings = s.split(" ");
        String temp;
        for (int i = 0, j = strings.length - 1; i < j; i++, j--){
            temp = strings[i];
            strings[i] = strings[j];
            strings[j] = temp;
        }
        StringBuilder builder = new StringBuilder();
        for (String s1 : strings){
            builder.append(s1);
            builder.append(" ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(reverseString(s));
    }

}
