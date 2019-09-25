package com.dang.leetcode.string;

/**
 * 学生出勤记录 I(https://leetcode-cn.com/problems/student-attendance-record-i/submissions/)
 * @author dht
 * @date 24/09/2019
 */
public class Q_551 {

    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLP"));
        System.out.println(checkRecord("PPALLL"));
    }

    public static boolean checkRecord(String s) {
        char[] chars = s.toCharArray();
        int countA = 0, countL = 0;
        for (int i = 0; i < chars.length; i++) {
            if ('A' == chars[i]) {
                countA++;
                countL = 0;
            }
            else if ('L' == chars[i]) {
                countL++;
            }
            else {
                countL = 0;
            }
            if (countA > 1 || countL > 2) {
                return false;
            }
        }
        return true;
    }

}
