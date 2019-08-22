package com.dang.leetcode.math;

/**
 * 丑数(https://leetcode-cn.com/problems/ugly-number/)
 * @author dht
 * @date 13/08/2019
 */
public class Q_263 {

    public static void main(String[] args) {
        System.out.println(isUgly(6));
        System.out.println(isUgly(8));
        System.out.println(isUgly(-2147483648));
    }

    public static boolean isUgly(int num) {
        if(num==0)
            return false;
        while(num%2==0)
            num/=2;
        while(num%3==0)
            num/=3;
        while(num%5==0)
            num/=5;
        return num==1;
    }

}
