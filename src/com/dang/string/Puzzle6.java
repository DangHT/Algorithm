package com.dang.string;

/**
 * <p>给定一个字符串数组strs, 请找到一种拼接顺序,
 * 使得所有给定的字符串拼接起来的大字符串是所有
 * 可能性中字典顺序最小的, 并返回该大字符串</p>
 * 例如:
 * strs = ["abc". "de"] 可以拼接成"abcde", 也可以
 * 拼成"deabc", 但前者字典顺序更小, 所以返回"abcde"
 * strs = ["b", "ba"] 可以拼成"bba", 也可以拼成"bab"
 * 但后者字典顺序更小, 所以返回"bab"
 * @author dht925nerd@126.com
 * @date 2019/03/03
 */
public class Puzzle6 {

    /**
     * <p>最优解的时间复杂度O(N*logN), 其实质是一种排序的实现</p>
     * 方案一: 根据单独每个字符串的字典顺序排序
     * ["abc", "de"] --(排序)--> ["abc", "de"]
     * <br>
     * 但是方案一是<b>错误的</b>, 比如:
     * ["ba", "b"] --(排序)--> ["b", "ba"]
     * 拼接后为"bba", 但是"bab"的字典顺序更小
     * <br>
     * 方案二: str1和str2按照如下方式比较:
     * 如果str1+str2 < str2+str1, 则str1放在前面,
     * 否则, str2放在前面
     * @param strs strs
     * @return answer
     */
    private static String solution(String[] strs){
        if (strs == null) return null;
        String temp;
        for (int i = 1; i < strs.length; i++){
            for (int j = i - 1; j >= 0; j--){
                if (compare(strs[i], strs[j]) > 0){
                    temp = strs[i];
                    strs[i] = strs[j];
                    strs[j] = temp;
                } else break;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String s : strs){
            builder.append(s);
        }
        return builder.toString();
    }

    /**
     * 比较str1, str2拼接后的字典顺序
     * @param str1 str1
     * @param str2 str2
     * @return 1-str1在前; 0-相等; -1-str2在前
     */
    private static int compare(String str1, String str2){
        if (str1 == null && str2 == null) return 0;
        if (str1 == null) return 1;
        if (str2 == null) return -1;
        char[] chars1 = (str1 + str2).toCharArray();
        char[] chars2 = (str2 + str1).toCharArray();
        int i = 0, j = 0;
        while (i < chars1.length && j < chars2.length){
            if (chars1[i] < chars2[j]) return 1;
            if (chars1[i] > chars2[j]) return -1;
            i++; j++;
        }
        if (i < chars1.length) return 1;
        if (j < chars2.length) return -1;
        return 0;
    }

    public static void main(String[] args) {
        String[] strs = {"b", "ba"};
        System.out.println(solution(strs));
    }

}
