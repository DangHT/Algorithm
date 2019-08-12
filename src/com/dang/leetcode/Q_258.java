package com.dang.leetcode;

/**
 * 各位相加(https://leetcode-cn.com/problems/add-digits/)
 * @author dht
 * @date 12/08/2019
 */
public class Q_258 {

    public static void main(String[] args) {
        System.out.println(addDigits_01(38));
    }

    public static int addDigits_01(int num) {
        if (num < 10) return num;
        return addDigits_01(digit(num));
    }

    private static int digit(int num) {
        if (num < 10) return num;
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static int addDigits_02(int num) {
        while(num/10>0){
            num = num/10+num%10;
        }
        return num;
    }

}
