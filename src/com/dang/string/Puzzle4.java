package com.dang.string;

/**
 * 给定一个字符串str, 请在单词间做逆序调整
 * 例如:
 * "pig loves dog" 逆序成 "dog loves pig"
 * "I'm a student." 逆序成 "student. a I'm"
 * @author dht925nerd@126.com
 * @date 2019/03/03
 */
public class Puzzle4 {

    private static String solution(String str){
        if (str == null) return null;
        String[] strs = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--){
            builder.append(strs[i]).append(" ");
        }
        builder.delete(builder.length() - 1, builder.length());
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("pig loves dog"));
        System.out.println(solution("I'm a student."));
    }

}
