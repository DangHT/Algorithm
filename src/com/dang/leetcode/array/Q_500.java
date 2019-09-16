package com.dang.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 键盘行(https://leetcode-cn.com/problems/keyboard-row/)
 *
 * @author dht
 * @date 12/09/2019
 */
public class Q_500 {

    private static HashMap<Character, Integer> map = new HashMap<>();

    static {
        map.put('q', 1);
        map.put('w', 1);
        map.put('e', 1);
        map.put('r', 1);
        map.put('t', 1);
        map.put('y', 1);
        map.put('u', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('p', 1);
        map.put('a', 2);
        map.put('s', 2);
        map.put('d', 2);
        map.put('f', 2);
        map.put('g', 2);
        map.put('h', 2);
        map.put('j', 2);
        map.put('k', 2);
        map.put('l', 2);
        map.put('z', 3);
        map.put('x', 3);
        map.put('c', 3);
        map.put('v', 3);
        map.put('b', 3);
        map.put('n', 3);
        map.put('m', 3);
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        words = findWords(words);
        for (String s : words) {
            System.out.println(s + " ");
        }
    }

    public static String[] findWords(String[] words) {
        List<String> strings = new ArrayList<>();
        for (String s : words) {
            char[] chars = s.toCharArray();
            int row = map.get(toLower(chars[0]));
            boolean flag = true;
            for (int i = 1; i < chars.length; i++) {
                if (row != map.get(toLower(chars[i]))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                strings.add(s);
            }
        }
        String[] results = new String[strings.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = strings.get(i);
        }
        return results;
    }

    private static char toLower(char c) {
        if (65 <= c && 90 >= c) {
            c += 32;
        }
        return c;
    }

}
