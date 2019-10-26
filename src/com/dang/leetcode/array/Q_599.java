package com.dang.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两个列表的最小索引总和(https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/)
 * @author dht
 * @date 25/10/2019
 */
public class Q_599 {

    public static void main(String[] args) {
        Q_599 q_599 = new Q_599();

        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        for (String s : q_599.findRestaurant(list1, list2)) {
            System.out.println(s);
        }
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        String[] shortList = list1.length < list2.length ? list1 : list2;
        String[] longList = list1.length < list2.length ? list2 : list1;
        List<String> resList = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < shortList.length; i++) {
            map.put(shortList[i], i);
        }

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < longList.length; i++) {
            if (i > minSum) break;
            if (map.containsKey(longList[i])) {
                int indexSum = i + map.get(longList[i]);
                if (minSum > indexSum) {
                    resList = new ArrayList<>();
                    resList.add(longList[i]);
                    minSum = indexSum;
                }
                else if (minSum == indexSum) {
                    resList.add(longList[i]);
                }
            }
        }

        String[] result = new String[resList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resList.get(i);
        }
        return result;
    }

}
