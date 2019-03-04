package com.dang.stackandqueue;

import java.util.Queue;
import java.util.Stack;

/**
 * 实现一个特殊的栈, 在实现栈的基本功能上,
 * 再实现返回栈中最小元素的操作getMin
 * @author dht925nerd@126.com
 * @date 2019/03/04
 */
public class Puzzle1 {

    static class MyStack{
        private Stack<Integer> data;
        private Stack<Integer> min;

        public MyStack() {
            this.data = new Stack<>();
            this.min = new Stack<>();
        }

        public Integer push(Integer item){
            if (min.empty()){
                min.push(item);
            } else {
                if (item < min.peek())
                    min.push(item);
                else
                    min.push(min.peek());
            }
            return this.data.push(item);
        }

        public Integer pop(){
            this.min.pop();
            return this.data.pop();
        }

        public Integer peek(){
            return this.data.peek();
        }

        public Integer getMin(){
            return this.min.peek();
        }

        public boolean empty(){
            return data.empty();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(1);
        myStack.push(2);
        myStack.push(1);
        while (!myStack.empty()){
            System.out.println(myStack.getMin()+ " " + myStack.pop());
        }
    }

}
