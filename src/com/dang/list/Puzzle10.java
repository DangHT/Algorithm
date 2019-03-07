package com.dang.list;

/**
 * 如何判断两个无环单链表是否相交, 相交的话
 * 返回第一个相交的节点, 不相交的话返回空,
 * 如果两个链表长度分别为 N 和 M, 请做到
 * 时间复杂度O(N+M), 空间复杂度O(1)
 * @author dht925nerd@126.com
 * @date 2019/03/06
 */
public class Puzzle10 {

    protected static ListNode<Integer> solution(ListNode<Integer> list1, ListNode<Integer> list2, ListNode<Integer> end){
        if (list1 == null || list2 == null) return null;
        int len1 = 0, len2 = 0, count = 0, len3;
        ListNode<Integer> temp1 = list1, temp2 = list2;
        while (temp1 != end){
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != end){
            len2++;
            temp2 = temp2.next;
        }
        temp1 = list1;
        temp2 = list2;
        len3 = len1 - len2;
        if (len3 > 0){
            while (temp1 != temp2 && temp1 != end && temp2 != end){
                if (count >= len3){
                    temp2 = temp2.next;
                }
                count++;
                temp1 = temp1.next;
            }
        } else {
            while (temp1 != temp2 && temp1 != end && temp2 != end){
                if (count <= len3){
                    temp1 = temp1.next;
                }
                count--;
                temp2 = temp2.next;
            }
        }
        return temp1;
    }

    public static void main(String[] args) {
        ListNode<Integer> list1 = new ListNode<>(1);
        list1.next = new ListNode<>(2);
        list1.next.next = new ListNode<>(3);
        list1.next.next.next = new ListNode<>(4);
        list1.next.next.next.next = new ListNode<>(5);
        ListNode<Integer> list2 = new ListNode<>(-1);
        list2.next = new ListNode<>(0);
        list2.next.next = new ListNode<>(1);
        list2.next.next.next = new ListNode<>(2);
        list2.next.next.next.next = list1.next.next;
        System.out.println(solution(list1, list2, null).val);
    }

}
