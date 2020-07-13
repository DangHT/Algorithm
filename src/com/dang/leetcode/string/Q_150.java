package com.dang.leetcode.string;

import java.util.Stack;

/**
 * 逆波兰表达式求值(https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/)
 * @author DangHT
 * @date 2020/07/13
 */
public class Q_150 {

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (Character.isDigit(s.charAt(0))) {
                stack.push(Integer.parseInt(s));
            } else if ('-' == s.charAt(0) && s.length() > 1) {
                stack.push(Integer.parseInt(s));
            } else {
                int a = stack.pop(), b = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(b / a);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Q_150 q_150 = new Q_150();
        String[] tokens = {"4", "3", "-"};
        System.out.println(q_150.evalRPN(tokens));
    }
}
