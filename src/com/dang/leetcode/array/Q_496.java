package com.dang.leetcode.array;

/**
 * 下一个更大元素 I(https://leetcode-cn.com/problems/next-greater-element-i/)
 * @author dht
 * @date 11/09/2019
 */
public class Q_496 {

    public static void main(String[] args) {
        int[] num1 = {2, 4};
        int[] num2 = {1, 2, 3, 4};
        int[] result  = nextGreaterElement(num1, num2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            boolean flag = false;
            result[i] = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i])
                    flag = true;
                if (flag && nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
            if (result[i] == nums1[i]) result[i] = -1;
        }
        return result;
    }

}
