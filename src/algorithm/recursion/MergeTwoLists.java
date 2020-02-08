package algorithm.recursion;


import algorithm.doublePointer.ListNode;

/**
 * 21. 合并两个有序链表
 * 递归就是程序内部维护了一个栈。这个题就是每次都把最小值压入栈，最后出栈的时候，将所有数连在一起就可以了。
 * 终止条件：两条链表分别名为l1和l2，当l1为空或l2为空时结束
 * 返回值：每一层调用都返回排序好的链表头
 * 本级递归内容：如果l1的val值更小，则将l1.next与排序好的链表头相接，l2同理
 * O(m+n)，m为l1的长度，n为l2的长度
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            //l1都等于null了，肯定是l2更大呀
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
