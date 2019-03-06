package com.dang.list;

/**
 * 给定一个链表的头节点 head, 再给定一个数 num,
 * 请把链表调整成节点值小于 num 的节点都放在链表
 * 的左边, 值等于 num 的节点都放在链表的中间, 值
 * 大于 num 的节点, 都放在链表的右边
 * @author dht925nerd@126.com
 * @date 2019/03/06
 */
public class Puzzle3 {

    private static ListNode<Integer> solution(ListNode<Integer> head, int num){
        if (head == null) return null;
        ListNode<Integer> pre = null, preCur = null, in = null, inCur = null, post = null, postCur = null, temp;
        for (temp = head; temp != null; temp = temp.next){
            if (temp.val < num){
                if (pre == null){
                    pre = temp;
                } else {
                    preCur.next = temp;
                }
                preCur = temp;
            }
            if (temp.val == num){
                if (in == null){
                    in = temp;
                } else {
                    inCur.next = temp;
                }
                inCur = temp;
            }
            if (temp.val > num){
                if (post == null){
                    post = temp;
                } else {
                    postCur.next = temp;
                }
                postCur = temp;
            }
        }
        head = pre;
        preCur.next = in;
        inCur.next = post;
        postCur.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode<Integer> list = new ListNode<>(3);
        list.next = new ListNode<>(1);
        list.next.next = new ListNode<>(2);
        list.next.next.next = new ListNode<>(1);
        list = solution(list, 2);
        while (list != null){
            System.out.print(list.val + " ");
            list = list.next;
        }
    }

}
