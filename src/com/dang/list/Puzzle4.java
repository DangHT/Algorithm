package com.dang.list;

/**
 * 给定两个有序链表的头节点 head1 和 head2
 * 打印两个有序链表的公共部分
 * @author dht925nerd@126.com
 * @date 2019/03/06
 */
public class Puzzle4 {

    private static void solution(ListNode<Integer> head1, ListNode<Integer> head2){
        if (head1 == null || head2 == null) return;
        ListNode<Integer> cur1 = head1, cur2 = head2;
        while (cur1 != null && cur2 != null){
            if (cur1.val < cur2.val){
                cur1 = cur1.next;
            } else if (cur1.val > cur2.val){
                cur2 = cur2.next;
            } else {
                System.out.print(cur1.val + " ");
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode<Integer> head1 = new ListNode<>(1);
        head1.next = new ListNode<>(3);
        head1.next.next = new ListNode<>(4);
        head1.next.next.next = new ListNode<>(7);
        ListNode<Integer> head2 = new ListNode<>(2);
        head2.next = new ListNode<>(3);
        head2.next.next = new ListNode<>(5);
        head2.next.next.next = new ListNode<>(7);
        head2.next.next.next.next = new ListNode<>(9);
        solution(head1, head2);
    }

}
