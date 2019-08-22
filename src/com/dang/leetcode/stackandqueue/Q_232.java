package com.dang.leetcode.stackandqueue;

import java.util.Stack;

/**
 * 用栈实现队列（https://leetcode-cn.com/problems/implement-queue-using-stacks/）
 * @author dht
 * @date 04/08/2019
 */
public class Q_232 {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

}

class MyQueue {

    private Stack<Integer> from, to;
    private int count;

    /** Initialize your data structure here. */
    public MyQueue() {
        from = new Stack<>();
        to = new Stack<>();
        count = 0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        from.push(x);
        count++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int result = 0;
        while (count > 0) {
            if (count == 1) result = from.pop();
            else to.push(from.pop());
            count--;
        }
        while (!to.empty()) {
            from.push(to.pop());
            count++;
        }
        return result;
    }

    /** Get the front element. */
    public int peek() {
        int result = 0;
        while (count > 0) {
            if (count == 1) result = from.peek();
            to.push(from.pop());
            count--;
        }
        while (!to.empty()) {
            from.push(to.pop());
            count++;
        }
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return from.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */