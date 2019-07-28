package com.dang.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈 (https://leetcode-cn.com/problems/implement-stack-using-queues/)
 * @author dht
 * @date 27/07/2019
 */
public class Q_225 {

    public static void main(String[] args) {
        MyStack_Optimized obj = new MyStack_Optimized();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.empty());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }

}

/**
 * 我的思路：
 * 使用两个队列来回倒数据实现栈
 */
class MyStack {

    private Queue<Integer> queue_from, queue_to;
    private int count;

    /** Initialize your data structure here. */
    public MyStack() {
        queue_from = new LinkedList<>();
        queue_to = new LinkedList<>();
        count = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue_from.offer(x);
        count++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int result = 0;
        while (!queue_from.isEmpty()) {
            count--;
            if (count == 0) {
                result = queue_from.poll();
                break;
            }
            queue_to.offer(queue_from.poll());
        }
        while (!queue_to.isEmpty()) {
            queue_from.offer(queue_to.poll());
            count++;
        }
        return result;
    }

    /** Get the top element. */
    public int top() {
        int result = 0;
        while (!queue_from.isEmpty()) {
            count--;
            if (count == 0)
                result = queue_from.peek();
            queue_to.offer(queue_from.poll());
        }
        while (!queue_to.isEmpty()) {
            queue_from.offer(queue_to.poll());
            count++;
        }
        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return count == 0;
    }
}

/**
 * 最优解使用双端队列Deque实现
 */
class MyStack_Optimized {

    Deque<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack_Optimized() {
        queue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offerFirst(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (!queue.isEmpty()) {
            return queue.pollFirst();
        }
        return -1;
    }

    /** Get the top element. */
    public int top() {
        if (!queue.isEmpty()) {
            return queue.peekFirst();
        }
        return -1;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
