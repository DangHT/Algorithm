package com.dang.nwpu.y2018;

/**
 * 有这样一类数字, 顺着看和倒着看是相同的数, 例如:121, 656, 2332等,
 * 这样的数字就称为“回文数字”, 请编程判断所给数字是否是回文数字
 * @author dht925nerd@126.com
 * @date 2019/02/26
 */
public class Solution5 {

    private static boolean isPalindromeNumber(int num){
        if (num < 0) return false;
        if (num < 10) return true;
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--){
            if (chars[i] != chars[j])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {121, 656, 2332, 223, 22278222};
        for (int num : nums){
            System.out.println(num + ":" + isPalindromeNumber(num));
        }
    }
}
