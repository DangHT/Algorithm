package com.dang.leetcode.array;

import java.util.Arrays;

/**
 * 相对名次(https://leetcode-cn.com/problems/relative-ranks/)
 * @author dht
 * @date 20/09/2019
 */
public class Q_506 {

    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 5, 1};
        Q_506 solution = new Q_506();
        String[] ranks = solution.findRelativeRanks(nums);
        for (String s : ranks) {
            System.out.println(s);
        }
    }

    public String[] findRelativeRanks(int[] nums) {
        Item[] items = new Item[nums.length];
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(nums[i], i);
        }
        Arrays.sort(items, (o1, o2) -> {
            if (o1.value == o2.value) return 0;
            if (o1.value < o2.value) return 1;
            else return -1;
        });
        String[] ranks = new String[items.length];
        ranks[items[0].index] = "Gold Medal";
        if (items.length > 1) ranks[items[1].index] = "Silver Medal";
        if (items.length > 2) ranks[items[2].index] = "Bronze Medal";
        for (int i = 3; i < ranks.length; i++) {
            ranks[items[i].index] = String.valueOf(i + 1);
        }
        return ranks;
    }

    class Item {
        int value;
        int index;
        public Item(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

}
