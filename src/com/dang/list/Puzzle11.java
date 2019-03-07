package com.dang.list;

/**
 * 如何判断两个有环单链表是否相交, 相交的话
 * 返回第一个相交的节点, 不相交的话返回空,
 * 如果两个链表长度分别为 N 和 M, 请做到
 * 时间复杂度O(N+M), 空间复杂度O(1)
 * @author dht925nerd@126.com
 * @date 2019/03/07
 */
public class Puzzle11 {

    protected static ListNode<Integer> solution(ListNode<Integer> list1, ListNode<Integer> list2){
        if (list1 == null || list2 == null) return null;
        //找到两个链表各自的入环节点,
        ListNode<Integer> list1LoopHead = Puzzle9.solution(list1);
        ListNode<Integer> list2LoopHead = Puzzle9.solution(list2);
        if (list1LoopHead == list2LoopHead) {
            return Puzzle10.solution(list1, list2, list1LoopHead);
        } else {
            ListNode<Integer> temp = list1LoopHead;
            do {
                temp = temp.next;
                if (temp == list2LoopHead) return temp;
            } while (temp != list1LoopHead);
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode<Integer> list1 = new ListNode<>(1);
        list1.next = new ListNode<>(2);
        list1.next.next = new ListNode<>(3);
        list1.next.next.next = new ListNode<>(4);
        list1.next.next.next.next = new ListNode<>(5);
        list1.next.next.next.next.next = list1.next.next;
        ListNode<Integer> list2 = new ListNode<>(0);
        list2.next = new ListNode<>(1);
        list2.next.next = new ListNode<>(2);
        list2.next.next.next = list1.next.next;
        System.out.println(solution(list1, list2).val);
    }

}
