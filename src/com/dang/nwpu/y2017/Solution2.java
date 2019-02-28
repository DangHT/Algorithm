package com.dang.nwpu.y2017;

import java.util.Scanner;

/**
 * 从键盘输入一个字符串(不多于80个字符), 将其中的数字字符按照
 * 原顺序组成一个新的字符串并输出
 * @author dht925nerd@126.com
 * @date 2019/02/28
 */
public class Solution2 {

    private static String findNumericCharacter(String s){
        if (s == null || s.length() > 80) return null;
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c : chars){
            if (c >= '0' && c <= '9'){
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(findNumericCharacter(s));
    }

}
