package com.dang.list;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 给定一个单链表的头节点为 head, 实现一个调整单链表
 * 的函数, 使得每 K 个节点之间逆序, 如果最后不够 K 个
 * 节点一组, 则不调整最后几个节点
 * 例如:
 * 链表:1->2->3->4->5->6->7->8->null, K=3
 * 调整后:3->2->1->6->5->4->7->8->null
 * 因为 K==3, 所以每三个节点之间逆序, 但其中的 7, 8 不调整,
 * 因为只有两个节点不构成一组
 * @author dht925nerd@126.com
 * @date 2019/03/06
 */
public class Puzzle5 {

    private static ListNode<Integer> solution(ListNode<Integer> list, int K){
        if (list == null) return null;
        Stack<Integer> stack = new Stack<>();
        ListNode<Integer> head = list, cur = list, temp = null;
        int count = 0;
        ArrayList<Integer> rest = new ArrayList<>();
        while (cur != null){
            stack.push(cur.val);
            cur = cur.next;
            count++;
            if (count % K == 0){
                if (count == K){
                    head = new ListNode<>(stack.pop());
                    temp = head;
                }
                while (!stack.empty() && temp != null){
                    temp.next = new ListNode<>(stack.pop());
                    temp = temp.next;
                }
            }
        }
        for (int i = 0; !stack.empty(); i++){
            rest.add(stack.pop());
        }
        for (int i = rest.size() - 1; temp != null && i >= 0; i--){
            temp.next = new ListNode<>(rest.get(i));
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode<Integer> list = new ListNode<>(1);
        list.next = new ListNode<>(2);
        list.next.next = new ListNode<>(3);
        list.next.next.next = new ListNode<>(4);
        list.next.next.next.next = new ListNode<>(5);
        list.next.next.next.next.next = new ListNode<>(6);
        list.next.next.next.next.next.next = new ListNode<>(7);
        list.next.next.next.next.next.next.next = new ListNode<>(8);
        list = solution(list, 3);
        while (list != null){
            System.out.print(list.val + " ");
            list = list.next;
        }
    }

}
