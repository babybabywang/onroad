package dev.onroad.algorithm;

import dev.onroad.algorithm.construction.ListNode;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-07 23:16
 * @description 反转链表 206
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //当前节点 1->2->3->null
        ListNode cur = head;
        //后继节点
        ListNode pre = null;
        //cur！=null循环
        while (cur != null) {
            //下一个临时节点 2->3->null 3->null
            ListNode nextTemp = cur.next;
            //下一个临时节点=后继 null  1->null
            cur.next = pre;
            //后继节点=当前节点 1->null 2->1->null
            pre = cur;
            //当前节点=下一个临时节点 2->3->null 3->null
            cur = nextTemp;
        }
        return pre;
    }
}
