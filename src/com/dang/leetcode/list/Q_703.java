package com.dang.leetcode.list;

import java.util.*;

/**
 * 数据流中的第K大元素(https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/)
 * @author dht
 * @date 21/11/2019
 */
public class Q_703 {

    public static void main(String[] args) {
        Q_703 q_703 = new Q_703();

        int k = 1;
        int[] arr = {};
        KthLargest kthLargest = new KthLargest(k, arr);
        kthLargest.add(-3);
        kthLargest.add(-2);
        kthLargest.add(-4);
        kthLargest.add(0);
        kthLargest.add(4);
    }

}

class KthLargest {

    private int k;

    private List<Integer> list;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.list = new LinkedList<>();
        Arrays.sort(nums);
        int i = nums.length > k ? nums.length - k : 0;
        while (i < nums.length) {
            this.list.add(nums[i++]);
        }
    }

    public int add(int val) {
        if (list.size() == k && val <= list.get(0)) return list.get(0);
        if (list.size() == k) list.remove(0);
        if (list.size() == 0) {
            list.add(val);
            return val;
        }
        boolean flag = false;
        int head = 0, tail = list.size() - 1;
        while (head < tail) {
            int center = head + (tail - head) / 2;
            int v = list.get(center);
            if (v == val) {
                list.add(center, val);
                flag = true;
                break;
            }
            if (v < val) {
                head = center + 1;
            } else {
                tail = center - 1;
            }
        }
        if (!flag) {
            if (val > list.get(head)) {
                list.add(head + 1, val);
            } else {
                list.add(head, val);
            }
        }
        return list.get(0);
    }

}

class KthLargest_Queue {

    private int k;

    private Queue<Integer> queue;

    public KthLargest_Queue(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);
        for (int i : nums) {
            if (queue.size() < k) {
                queue.add(i);
            } else {
                if (i > queue.peek()) {
                    queue.poll();
                    queue.add(i);
                }
            }
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.add(val);
        } else {
            if (val > queue.peek()) {
                queue.poll();
                queue.add(val);
            }
        }
        return queue.peek();
    }

}
