package com.dang.string;

/**
 * 给定一个字符串str, 和一个整数i, i代表str中的位置,
 * 将str[0...i]移到右侧, str[i+1...N-1]移到左侧
 * 例如:
 * str = "ABCDE", i = 2  将str调整为"DEABC"
 * 要求:
 * 时间复杂度O(N), 额外空间复杂度O(1)
 * @author dht925nerd@126.com
 * @date 2019/03/03
 */
public class Puzzle5 {

    /**
     * 1. 将str[0...i]部分的字符逆序
     * 2. 将str[i+1...N-1]部分的字符逆序
     * 3. 将str整体逆序
     * @param str str
     * @param i i
     * @return answer
     */
    private static String solution(String str, int i){
        char[] chars = str.toCharArray();
        reverse(chars, 0, i);
        reverse(chars, i + 1, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return String.valueOf(chars);
    }

    private static void reverse(char[] chars, int from, int to){
        if (chars == null) return;
        char temp;
        for (int i = from, j = to; i < j; i++, j--){
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }

    public static void main(String[] args) {
        String str = "ABCDE";
        System.out.println(solution(str, 2));
    }

}
