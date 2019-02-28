package com.dang.nwpu.y2017;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 从键盘上随机输入 20 个正整数, 找出并输出所包含的质数
 * @author dht925nerd@126.com
 * @date 2019/02/28
 */
public class Solution7 {

    private static void findPrime(int[] nums){
        if (nums == null || nums.length == 0) return;
        Arrays.sort(nums);
        boolean[] mark = new boolean[nums[nums.length - 1] + 1];
        mark[0] = true; mark[1] = true;
        for (int i = 2; i < mark.length; i++){
            if (!mark[i]){
                int j = 2;
                while (i * j < mark.length){
                    mark[i * j] = true;
                    j++;
                }
            }
        }
        for (int i : nums){
            if (!mark[i]) System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String[] strings = string.split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(strings[i]);
        }
        findPrime(nums);
    }

}
