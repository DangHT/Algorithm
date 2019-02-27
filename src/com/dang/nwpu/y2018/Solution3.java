package com.dang.nwpu.y2018;

/**
 * 从键盘输入一个长字符串, 找出并输出其中所有的三个连续字符
 * 例如"abc"或者"efg"等
 * @author dht925nerd@126.com
 * @date 2019/02/26
 */
public class Solution3 {

    private static void findContiguousCharacter(String string){
        if (string == null || string.length() < 3) return;
        char[] chars = string.toCharArray();
        int count = 1;
        for (int i = 1; i < chars.length; i++){
            if (chars[i] == chars[i - 1] + 1){
                count++;
                if (count == 3){
                    for (int j = i - 2; j <= i; j++){
                        System.out.print(chars[j]);
                    }
                    System.out.println();
                    count--;
                }
            } else count = 1;
        }
    }

    public static void main(String[] args) {
        String s = "abcasdqwbcdawuehiuefghijk";
        findContiguousCharacter(s);
    }

}
