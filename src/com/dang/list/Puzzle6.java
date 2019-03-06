package com.dang.list;

/**
 * 给定一个单链表的头节点 head, 链表中每个节点
 * 保存一个整数, 再给定一个值 val, 把所有等于
 * val 的节点删掉
 * @author dht925nerd@126.com
 * @date 2019/03/06
 */
public class Puzzle6 {

    private static void solution(ListNode<Integer> head, int val){
        if (head == null) return;
        ListNode<Integer> pre = head, cur;
        while (pre.val == val) pre = pre.next;
        cur = pre.next;
        while (cur != null){
            if (cur.val == val) {
                pre.next = cur.next;
                cur = pre.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode<Integer> list = new ListNode<>(7);
        list.next = new ListNode<>(1);
        list.next.next = new ListNode<>(3);
        list.next.next.next = new ListNode<>(1);
        solution(list, 1);
        while (list != null){
            System.out.print(list.val + " ");
            list = list.next;
        }
    }

}
