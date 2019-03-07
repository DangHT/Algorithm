package com.dang.list;

/**
 * 给定两个单链表的头节点 head1 和 head2, 如何判断两个
 * 链表是否相交? 相交的话返回第一个相交的节点, 不相交的话
 * 返回空
 * @author dht925nerd@126.com
 * @date 2019/03/07
 */
public class Puzzle12 {

    /**
     * 1. 利用{@link Puzzle9}找到两个链表各自的入环节点
     *    假设: head1 的链表入环节点为 node1
     *         head2 的链表入环节点为 node2
     * 2. 如果 node1 和 node2, 一个为空, 另一个不为空,
     *    则连个链表不可能相交
     * 3. 如果 node1 和 node2 都等于空, 说明两个链表都
     *    无环, 则用{@link Puzzle10}进行后续解答
     * 4. 如果 node1 和 node2 都不为空, 说明两个链表都
     *    有环, 则用{@link Puzzle11}进行后续解答
     * @param list1 list1
     * @param list2 list2
     * @return answer
     */
    private static ListNode<Integer> solution(ListNode<Integer> list1, ListNode<Integer> list2){
        if (list1 == null || list2 == null) return null;
        ListNode<Integer> list1LoopHead = Puzzle9.solution(list1);
        ListNode<Integer> list2LoopHead = Puzzle9.solution(list2);
        if (list1LoopHead != null){
            if (list2LoopHead == null) {
                return null;
            } else {
                return Puzzle11.solution(list1, list2);
            }
        } else {
            if (list2LoopHead == null){
                return Puzzle10.solution(list1, list2, null);
            } else {
                return null;
            }
        }
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
