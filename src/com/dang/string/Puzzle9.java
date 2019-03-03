package com.dang.string;

import java.util.Arrays;

/**
 * 给定一个字符串, 返回str的最长无重复字符子串的长度
 * 例如:
 * str = "abcd", 则返回4
 * str = "abcb", 最长无重复字符子串为"abc", 则返回3
 * @author dht925nerd@126.com
 * @date 2019/03/03
 */
public class Puzzle9 {

    /**
     * 最优解时间复杂度为O(N), 额外空间复杂度O(N)
     * 求出以str中每个字符结尾的情况下, 最长无重复字符子串的长度,
     * 并在其中找出最大值返回
     * @param str str
     * @return answer
     */
    private static int solution(String str){
        if (str == null || str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        //map: 其中统计了每种字符之前出现的位置
        int[] map = new int[256];
        Arrays.fill(map, -1);
        //pre: 代表以chars[i-1]结尾的情况下, 最长无重复子串的长度
        int pre = 0, max = 1;
        map[chars[0]] = 0;
        for (int i = 1; i < chars.length; i++){
            if (map[chars[i]] != -1 && map[chars[i]] + 1 > pre){
                if (max < i - map[chars[i]] - 1) max = i - map[chars[i]] - 1;
                pre = map[chars[i]] + 1;
            } else {
                if (max < (i - pre + 1)) max = i - pre + 1;
            }
            map[chars[i]] = i;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcbbbcdeffff"));
    }

}
