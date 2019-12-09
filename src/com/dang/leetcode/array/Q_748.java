package com.dang.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 最短完整词(https://leetcode-cn.com/problems/shortest-completing-word/)
 *
 * @author dht
 * @date 03/12/2019
 */
public class Q_748 {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        char[] plateChars = licensePlate.toLowerCase().toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : plateChars) {
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int max = 0;
        String res = "";
        for (String word : words) {
            int tmp = countMatch(map, word);
            if (tmp > max || tmp == max && word.length() < res.length()) {
                res = word;
                max = tmp;
            }
        }
        return res;
    }

    private int countMatch(Map<Character, Integer> map, String word) {
        char[] chars = word.toLowerCase().toCharArray();
        int[] count = new int[128];
        int res = 0;
        for (char c : chars) {
            if (map.containsKey(c)) {
                if (count[c] < map.get(c)) res++;
                count[c]++;
            }
        }
        return res;
    }

}
