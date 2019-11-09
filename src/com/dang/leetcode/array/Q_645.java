package com.dang.leetcode.array;

/**
 * 错误的集合(https://leetcode-cn.com/problems/set-mismatch/)
 * @author dht
 * @date 09/11/2019
 */
public class Q_645 {

    public static void main(String[] args) {
        Q_645 q_645 = new Q_645();
        int[] nums = {1,5,3,2,2,7,6,4,8,9};
        int[] res = q_645.findErrorNums_time(nums);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public int[] findErrorNums_time(int[] nums) {
        int[] res = new int[2];
        int sum = 0;
        boolean[] exist = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (exist[nums[i]]) {
                res[0] = nums[i];
            } else {
                exist[nums[i]] = true;
            }
            sum += nums[i];
        }
        res[1] = (1 + nums.length) * nums.length / 2 - sum + res[0];
        return res;
    }

    public int[] findErrorNums_space(int[] nums) {
        int[] res = new int[2];
        int sum = 0, tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp = Math.abs(nums[i]);
            if (nums[tmp - 1] > 0) {
                nums[tmp - 1] *= -1;
            } else {
                res[0] = Math.abs(tmp);
            }
            sum += Math.abs(nums[i]);
        }
        res[1] = (1 + nums.length) * nums.length / 2 - sum + res[0];
        return res;
    }

}
