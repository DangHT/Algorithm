package com.dang.list;

/**
 * 如何判断一个单链表是否有环?
 * 有环的话返回进入环的第一个节点,
 * 无环的话返回空, 如果链表的长度为N
 * 请做到时间复杂度O(N), 空间复杂度O(1)
 * @author dht925nerd@126.com
 * @date 2019/03/06
 */
public class Puzzle9 {

    protected static ListNode<Integer> solution(ListNode<Integer> list){
        if (list == null || list.next == null) return null;
        ListNode<Integer> fast = list, slow = list;
        while (true){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null || fast.next == null) return null;
            if (fast == slow) break;
        }
        fast = list;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode<Integer> list = new ListNode<>(1);
        list.next = new ListNode<>(2);
        list.next.next = new ListNode<>(3);
        list.next.next.next = new ListNode<>(4);
        list.next.next.next.next = new ListNode<>(5);
        list.next.next.next.next.next = list.next.next;
        System.out.println(solution(list).val);
    }

}
