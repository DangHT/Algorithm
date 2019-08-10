package com.dang.leetcode;

import com.dang.list.ListNode;

import java.util.*;

/**
 * 回文链表(https://leetcode-cn.com/problems/palindrome-linked-list/)
 * @author dht
 * @date 10/08/2019
 */
public class Q_234 {

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(0);
        head.next.next = new ListNode<>(0);
//        head.next.next.next = new ListNode<>(1);
        System.out.println(isPalindrome_01(head));
    }

    /**
     * 使用双端队列求解
     * @param head
     * @return
     */
    public static boolean isPalindrome_01(ListNode<Integer> head) {
        if (head == null) return true;
        Deque deque = new ArrayDeque();
        while (head != null) {
            deque.add(head.val);
            head = head.next;
        }
        while (deque.size() > 1) {
            if (!Objects.equals(deque.pollFirst(), deque.pollLast()))
                return false;
        }
        return true;
    }

    /**
     * 使用快慢指针
     * @param head
     * @return
     */
    public static boolean isPalindrome_02(ListNode<Integer> head) {
        //如果链表为空或者只有一个节点，直接返回true
        if (head == null || head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode iter = slow;
        ListNode pre = null;
        //反转后半部分链表
        while (iter != null) {
            ListNode temp = iter.next;
            iter.next = pre;
            pre = iter;
            iter = temp;
        }
        iter = head;
        ListNode tail = pre;
        //开始对比，看是否有不同的值
        boolean flag = true;
        while (tail != null) {
            if (iter.val != tail.val) {
                flag = false;
                break;
            }
            iter = iter.next;
            tail = tail.next;
        }
        //恢复链表原来的结构，本质上就是再反转一次
        iter = pre;
        pre = null;
        while (iter != null) {
            ListNode temp = iter.next;
            iter.next = pre;
            pre = iter;
            iter = temp;
        }
        return flag;
    }

}
