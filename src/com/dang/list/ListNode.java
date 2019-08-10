package com.dang.list;

/**
 * 链表节点
 * @author dht925nerd@126.com
 * @date 2019/03/06
 */
public class ListNode<T> {

    public T val;
    public ListNode<T> next;

    /**
     * {@link Puzzle8}
     */
    ListNode<T> rand;

    public ListNode(T val) {
        this.val = val;
    }
}
