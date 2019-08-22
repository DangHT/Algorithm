package com.dang.leetcode.dp;

/**
 * 区域和检索-数组不可变(https://leetcode-cn.com/problems/range-sum-query-immutable/)
 * @author dht
 * @date 17/08/2019
 */
public class Q_303 {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
        System.out.println(numArray.sumRange(0, 0));
    }

}

class NumArray {

    private int[] nums;
    private int[] sums;

    public NumArray(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return;
        }
        this.nums = nums;
        sums = new int[this.nums.length + 1];
        sums[0] = 0;
        for (int i = 0; i < this.nums.length; i++){
            sums[i + 1] = sums[i] + this.nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (null != nums) {
            return sums[j + 1] - sums[i];
        }
        return 0;

        //很好的防止脏数据写法
//        int start = Math.min(i,j);
//        int end = Math.max(i,j);
//        start = Math.max(0,start);
//        end = Math.min(end, nums.length-1);
//        return sums[end + 1] - sums[start];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
