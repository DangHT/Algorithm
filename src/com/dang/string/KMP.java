package com.dang.string;

/**
 * KMP串匹配算法
 * @author dht925nerd@126.com
 * @date 2019/03/02
 */
public class KMP {

    /**
     * KMP主算法
     * @param pattern 模式串
     * @param text 文本
     * @return 匹配子串起始下标
     */
    public static int match(String pattern, String text){
        if (pattern == null || text == null) return -1;
        char[] pChars = pattern.toCharArray();
        char[] tChars = text.toCharArray();
        int[] next = buildNext(pattern);
        int i = 0, j = 0;
        while (j < pChars.length && i < tChars.length){
            if (0 > j || tChars[i] == pChars[j]){
                i++; j++;
            } else {
                j = next[j];
            }
        }
        return i - j;
    }

    /**
     * 构造模式串的next[]表
     * @param pattern 模式串
     * @return next[]表
     */
    private static int[] buildNext(String pattern) {
        if (pattern == null) return null;
        char[] chars = pattern.toCharArray();
        int[] next = new int[chars.length];
        int j = 0;
        int t = next[0] = -1;
        while (j < chars.length - 1){
            //若匹配
            if (0 > t || chars[j] == chars[t]) {
                j++;
                t++;
                next[j] = chars[j] != chars[t] ? t : next[t];
            }
            //若失配
            else
                t = next[t];
        }
        return next;
    }

    /**
     * 使用KMP算法判断text中是否含有与pattern匹配的子串
     * @param pattern 模式串
     * @param text 文本
     * @return answer
     */
    public static boolean hasSub(String pattern, String text){
        int flag = match(pattern, text);
        return flag >= 0 && flag < text.length();
    }

}
