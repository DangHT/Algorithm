package com.dang.stackandqueue;

import java.util.Stack;

/**
 * 一个栈中元素类型为整型, 现在想将该栈从顶到底按从大到小排序,
 * 只允许申请一个栈, 除此之外还可以申请新的变量, 但不能申请额外的
 * 数据结构, 请问如何完成排序?
 * @author dht925nerd@126.com
 * @date 2019/03/04
 */
public class Puzzle4 {

    private static void solution(Stack<Integer> stack){
        if (stack == null) return;
        Stack<Integer> help = new Stack<>();
        int temp;
        while (!stack.empty()){
            if (help.empty() || help.peek() > stack.peek()){
                help.push(stack.pop());
            } else {
                temp = stack.pop();
                while (!help.empty()){
                    stack.push(help.pop());
                }
                help.push(temp);
            }
        }
        while (!help.empty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(5);
        stack.push(2);
        stack.push(1);
        stack.push(3);
        solution(stack);
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }

}
