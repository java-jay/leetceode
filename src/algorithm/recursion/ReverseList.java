package algorithm.recursion;

import algorithm.doublePointer.ListNode;

/**
 * @Auther java_jay
 * @Date 2019/12/30
 */
public class ReverseList {
    //递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode newHead = reverseList(next);//只有两个元素时，newHead的地址和next一样，修改next就是修改newHead
        next.next = head;
        head.next = null;
        return newHead;
    }

    //迭代
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;//下一个值的临时存储
            curr.next = prev;//前一个值为下一个值
            prev = curr;//当前值为前一个值
            curr = nextTemp;//遍历到原链表的下一个值
        }
        return prev;
    }
}
