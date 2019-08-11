package com.dang.leetcode;

import com.dang.list.ListNode;

/**
 * 删除链表中的节点(https://leetcode-cn.com/problems/delete-node-in-a-linked-list/)
 * @author dht
 * @date 11/08/2019
 */
public class Q_237 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        ListNode tmp = node;
        while (tmp != null) {
            System.out.print(tmp.val + "->");
            tmp = tmp.next;
        }
        System.out.println();
        deleteNode(node.next.next);
        tmp = node;
        while (tmp != null) {
            System.out.print(tmp.val + "->");
            tmp = tmp.next;
        }
    }

    /**
     * 注意：本题中，仅仅给出了要删除的节点，而没有给出脸链表的其他任何节点
     * 我们无法找到所删除节点的前驱节点，因此无法直接通过修改next来删除节点
     * 只能通过将之后的节点向前重新赋值来解决
     * @param node
     */
    public static void deleteNode(ListNode node) {
        ListNode tmp = node;
        while (tmp != null && tmp.next != null) {
            tmp.val = tmp.next.val;
            if (tmp.next.next == null)
                tmp.next = null;
            else tmp = tmp.next;
        }
    }

}
