package com.dang.stackandqueue;

import java.util.Stack;

/**
 * 实现一个栈的逆序, 但是只能用递归函数和这个栈本身的操作来实现,
 * 而不能自己申请另外的数据结构
 * @author dht925nerd@126.com
 * @date 2019/03/04
 */
public class Puzzle3 {

    /**
     * 移除栈底元素并返回
     * @param stack stack
     * @return answer
     */
    private static int get(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.empty()){
            return result;
        } else {
            int last = get(stack);
            stack.push(result);
            return last;
        }
    }

    private static void solution(Stack<Integer> stack){
        if (stack == null || stack.empty()){
            return;
        }
        int i = get(stack);
        solution(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        solution(stack);
        while (!stack.empty())
            System.out.println(stack.pop());
    }

}
