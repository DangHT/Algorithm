package com.dang.list;

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构
 * 例如:
 * 链表:1->2->3->2->1, 是回文结构, 返回true
 * 链表:1->2->3->1, 不是回文结构, 返回false
 * @author dht925nerd@126.com
 * @date 2019/03/06
 */
public class Puzzle7 {

    /**
     * 将所有元素压入栈, 再依次弹出与链表节点比较
     * 弹出序列相当于原链表的逆序
     * 时间复杂度O(N), 空间复杂度O(N)
     * @param list list
     * @return answer
     */
    private static boolean solution1(ListNode<Integer> list){
        if (list == null) return false;
        ListNode<Integer> temp = list;
        Stack<Integer> stack = new Stack<>();
        while (temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = list;
        while (temp != null){
            if (!temp.val.equals(stack.pop())) return false;
            temp = temp.next;
        }
        return true;
    }

    /**
     * 设置快, 慢指针, 慢指针一次移动一个元素, 快指针一次移动两个元素
     * 当快指针到达末尾时, 慢指针刚好到达链表中间, 再比较元素
     * 时间复杂度O(N), 空间复杂度O(N/2)
     * @param list list
     * @return answer
     */
    private static boolean solution2(ListNode<Integer> list){
        if (list == null) return false;
        ListNode<Integer> fast = list, slow = list;
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        while (true){
            stack.push(slow.val);
            count++;
            if (fast.next == null || fast.next.next == null) break;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (count % 2 == 1) stack.pop();
        slow = slow.next;
        while (slow != null){
            if (!slow.val.equals(stack.pop())) return false;
            slow = slow.next;
        }
        return true;
    }

    /**
     * 快慢指针如solution2, 找到中间位置后, 将后半部分逆序
     * 再向中间逐步比较元素
     * 时间复杂度O(N), 空间复杂度O(1)
     * @param list list
     * @return answer
     */
    private static boolean solution3(ListNode<Integer> list){
        if (list == null) return false;
        ListNode<Integer> fast = list, slow = list, head = list, tail;
        while (true){
            if (fast.next == null || fast.next.next == null) break;
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = listReverse(slow);
        tail = fast;
        while (head != null && fast != null){
            if (!head.val.equals(fast.val)) return false;
            head = head.next;
            fast = fast.next;
        }
        listReverse(tail);
        return true;
    }

    /**
     * 链表原地逆序
     * @param list list
     * @return new head
     */
    private static ListNode<Integer> listReverse(ListNode<Integer> list){
        if (list == null || list.next == null) return list;
        ListNode<Integer> pre = null, cur = list, post = cur.next;
        while (true){
            cur.next = pre;
            pre = cur;
            cur = post;
            if (cur == null) break;
            post = post.next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode<Integer> list = new ListNode<>(1);
        list.next = new ListNode<>(2);
        list.next.next = new ListNode<>(3);
        list.next.next.next= new ListNode<>(2);
        list.next.next.next.next= new ListNode<>(1);
        System.out.println(solution3(list));
        while (list != null){
            System.out.print(list.val + " ");
            list = list.next;
        }
    }

}
