package com.dang.nwpu.y2018;

/**
 * 编程输入一个字符串, 将所有大写英文字母改为小写字母,
 * 所有小写字母改为大写字母, 然后输出
 * @author dht925nerd@126.com
 * @date 2019/02/26
 */
public class Solution6 {

    private static String convert(String s){
        char[] chars = s.toCharArray();
        int distant = 'a' - 'A';
        for (int i = 0; i < chars.length; i++){
            if ('a' <= chars[i] && 'z' >= chars[i])
                chars[i] -= distant;
            else if ('A' <= chars[i] && 'Z' >= chars[i])
                chars[i] += distant;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(convert("aAbBcCdD"));
    }
}
