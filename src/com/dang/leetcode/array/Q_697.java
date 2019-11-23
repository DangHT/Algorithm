package com.dang.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组的度(https://leetcode-cn.com/problems/degree-of-an-array/)
 * @author dht
 * @date 21/11/2019
 */
public class Q_697 {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> firstPos = new HashMap<>();
        Map<Integer, Integer> conut = new HashMap<>();
        int maxCount = 1, maxElement = -1, lastPos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (!firstPos.containsKey(nums[i])) {
                firstPos.put(nums[i], i);
            }
            if (!conut.containsKey(nums[i])) {
                conut.put(nums[i], 1);
            } else {
                int tmp = conut.get(nums[i]) + 1;
                conut.replace(nums[i], tmp);
                if (maxCount < tmp) {
                    maxCount = tmp;
                    maxElement = nums[i];
                    lastPos = i;
                } else if (maxCount == tmp) {
                    if (i - firstPos.get(nums[i]) < lastPos - firstPos.get(maxElement)) {
                        maxElement = nums[i];
                        lastPos = i;
                    }
                }
            }
        }
        if (maxCount == 1) return 1;
        return lastPos - firstPos.get(maxElement) + 1;
    }

}
