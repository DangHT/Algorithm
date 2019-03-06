package com.dang.list;

/**
 * 给定一个单链表中的节点 node, 但不给定整个链表的头结点,
 * 如何在链表中删除 node? 请实现这个函数, 要求时间复杂度为O(1)
 * @author dht925nerd@126.com
 * @date 2019/03/06
 */
public class Puzzle2 {

    /**
     * 复制下一个节点值并删除下一个节点
     * (注意:该方法无法删除链表最后一个节点)
     * 例如:
     * (...?) -> 3 -> null
     * 不能直接令节点 3 为 null, null 在系统中是一个特定的区域
     * 若要节点 3 的前驱结点指向 null 就必须找到节点 3 的前驱结点
     * @param node node
     */
    private static void solution(ListNode<Integer> node){
        if (node == null) return;
        if (node.next == null){
            System.out.println("无法删除最后一个节点!!!");
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public static void main(String[] args) {
        ListNode<Integer> list = new ListNode<>(1);
        list.next = new ListNode<>(2);
        list.next.next = new ListNode<>(3);
        ListNode<Integer> temp = list.next;
        solution(temp);
        while (list != null){
            System.out.print(list.val + " ");
            list = list.next;
        }
    }

}
