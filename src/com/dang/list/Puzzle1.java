package com.dang.list;

/**
 * 给定一个整数 num, 如何在节点值有序的环形链表中插入
 * 一个节点值为 num 的节点, 并保证这个环形单链表依然有序
 * @author dht925nerd@126.com
 * @date 2019/03/05
 */
public class Puzzle1 {

    private static ListNode<Integer> solution(ListNode<Integer> list, int num){
        if (list == null){
            list = new ListNode<>(num);
            list.next = list;
        } else {
            ListNode<Integer> pre = list, cur = pre.next;
            while (pre.val < cur.val) {
                if (pre.val <= num && cur.val >= num) {
                    pre.next = new ListNode<>(num);
                    pre.next.next = cur;
                    return list;
                }
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = new ListNode<>(num);
            pre.next.next = cur;
            if (pre.val > pre.next.val) list = pre.next;
        }
        return list;
    }

    private static void printCircularList(ListNode<Integer> head){
        if (head == null) return;
        ListNode temp = head;
        do {
            System.out.print(temp.val + " ");
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        ListNode<Integer> list = new ListNode<>(1);
        list.next = new ListNode<>(3);
        list.next.next = new ListNode<>(4);
        list.next.next.next = list;

        list = solution(list, 0);
        printCircularList(list);
    }

}
