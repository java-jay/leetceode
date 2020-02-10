package algorithm.recursion;

import algorithm.doublePointer.ListNode;

/**
 * 206. 反转链表
 *
 * @Auther java_jay
 * @Date 2019/12/30
 */
public class ReverseList {
    //递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        newHead.next = head;
        head.next = null;
        return newHead;
    }

    //迭代
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            //下一个值的临时存储
            ListNode next = cur.next;
            //前一个值为下一个值
            cur.next = pre;
            //当前值为前一个值
            pre = cur;
            //遍历到原链表的下一个值
            cur = next;
        }
        return pre;
    }
}
