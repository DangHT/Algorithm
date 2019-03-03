package com.dang.string;

/**
 * <p>给定两个字符串str1和str2, 如果str1和str2中出现的字符种类一样
 * 且每种字符出现的次数也一样, 那么str1与str2互为变形词,
 * 请实现函数判断两个字符串是否互为变形词</p>
 * 例如:
 * str1 = "123", str2 = "231"   返回:true
 * str1 = "123", str2 = "2331"  返回:false
 * @author dht925nerd@126.com
 * @date 2019/03/03
 */
public class Puzzle2 {

    /**
     * 使用哈希表做字符计数
     *      str1        str2
     *       |           |
     *    哈希表1      哈希表2
     *       \          /
     * 比较哈希表1与哈希表2的记录是否一致
     * 可以使用固定长度的数组代替哈希表结构
     * 时间复杂度O(N), 空间复杂度O(N)
     * @param str1 str1
     * @param str2 str1
     * @return answer
     */
    private static boolean solution(String str1, String str2){
        if (str1 == null && str2 == null) return true;
        if (str1 != null && str2 !=null){
            if (str1.length() != str2.length()) return false;
            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();
            int[] hash1 = new int[256];
            int[] hash2 = new int[256];
            for (char c : chars1){
                hash1[c]++;
            }
            for (char c : chars2){
                hash2[c]++;
            }
            for (int i = 0; i < hash1.length; i++){
                if (hash1[i] != hash2[i]) return false;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "2331";
        System.out.println(solution(str1, str2));
    }

}
