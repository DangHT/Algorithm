package com.dang.list;

/**
 * 一个链表结构中, 每个节点不仅含有一条指向下一个节点
 * 的 next 指针, 同时还有一条 rand 指针, rand 指针
 * 可能指向任何一个链表的节点, 请复制这种含有 rand
 * 指针节点的链表
 * 例:
 *
 *   _________1的rand指针___________
 *  |__2的rand指针__ __3的rand指针__|
 *  |             ||              |
 * (1) ————————> (2) ——————————> (3) ————————> null
 *
 * @author dht925nerd@126.com
 * @date 2019/03/06
 */
public class Puzzle8 {

    private static ListNode<Integer> solution(ListNode<Integer> list){
        if (list == null || list.next == null) return list;
        ListNode<Integer> head, pre = list, post = pre.next;
        while (post != null){
            pre.next = new ListNode<>(pre.val);
            pre.next.next = post;
            pre = post;
            post = post.next;
        }
        pre = list;
        while (pre.next != null){
            pre.next.rand = pre.rand.next;
            pre = pre.next.next;
        }
        head = list.next;
        pre = list;
        post = head;
        while (true){
            pre.next = post.next;
            pre = pre.next;
            if (pre.next == null) break;
            post.next= pre.next;
            post = post.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode<Integer> list = new ListNode<>(1);
        list.next = new ListNode<>(2);
        list.next.next = new ListNode<>(3);
        list.rand = list.next.next;
        list.next.rand = list;
        list.next.next.rand = list.next;
        ListNode<Integer> head = solution(list);
        ListNode<Integer> temp = list;
        System.out.print("原链表:");
        while (temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        temp = head;
        System.out.println();
        System.out.print("复制链表:");
        while (temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
        System.out.println("地址相同? " + (list == head));
    }

}
