package dev.onroad.algorithm;

import dev.onroad.algorithm.construction.ListNode;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-07 23:47
 * @description 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode start = curr.next;
            ListNode end = curr.next.next;
            curr.next = end;
            curr=null;
        }
        return prev;
    }
}
