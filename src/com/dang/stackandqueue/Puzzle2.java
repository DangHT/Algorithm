package com.dang.stackandqueue;

import java.util.Stack;

/**
 * 编写一个类只能用两个栈结构实现队列,
 * 支持队列的基本操作(add, poll, peek)
 * @author dht925nerd@126.com
 * @date 2019/03/04
 */
public class Puzzle2 {

    static class MyQueue{
        /**
         * 记录入队顺序
         */
        private Stack<Integer> stackPush;

        /**
         * 记录出队顺序
         */
        private Stack<Integer> stackPop;

        public MyQueue(){
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        public Integer add(Integer item){
            return stackPush.push(item);
        }

        /**
         * 注意:
         * 1. 如果StackPush要往StackPop中倒入数据,
         *    那么必须要把StackPush中的所有数据一次性倒完
         * 2. 如果StackPop中有数据, 则不能发生倒数据的行为
         */
        public Integer poll(){
            if (stackPop.empty()){
                while (!stackPush.empty())
                    stackPop.push(stackPush.pop());
            }
            return stackPop.pop();
        }

        public Integer peek(){
            if (stackPop.empty()){
                while (!stackPush.empty())
                    stackPop.push(stackPush.pop());
            }
            return stackPop.peek();
        }

        public boolean empty(){
            return stackPop.empty() && stackPush.empty();
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        myQueue.add(4);
        myQueue.add(5);
        while (!myQueue.empty()){
            System.out.println(myQueue.poll());
        }
        myQueue.add(6);
        System.out.println(myQueue.poll());
        myQueue.add(7);
        myQueue.add(8);
        myQueue.add(9);
        while (!myQueue.empty()){
            System.out.println(myQueue.poll());
        }
    }

}
