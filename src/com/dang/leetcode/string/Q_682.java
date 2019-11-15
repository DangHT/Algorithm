package com.dang.leetcode.string;

import java.util.LinkedList;
import java.util.List;

/**
 * 棒球比赛(https://leetcode-cn.com/problems/baseball-game/)
 * @author dht
 * @date 14/11/2019
 */
public class Q_682 {

    public static void main(String[] args) {
        Q_682 q_682 = new Q_682();
        String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println(q_682.calPoints(ops));
    }

    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) return 0;
        int sum = 0;
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < ops.length; i++) {
            int len = list.size(), cur = 0;
            switch (ops[i]) {
                case "+":
                    cur = list.get(len - 1) + list.get(len - 2);
                    list.add(cur);
                    break;
                case "D":
                    cur = list.get(len - 1) * 2;
                    list.add(cur);
                    break;
                case "C":
                    sum -= list.get(len - 1);
                    list.remove(len - 1);
                    break;
                default:
                    cur = Integer.parseInt(ops[i]);
                    list.add(cur);
            }
            sum += cur;
        }
        return sum;
    }

}
