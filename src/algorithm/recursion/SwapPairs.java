package algorithm.recursion;

/**
 * 24. 两两交换链表中的节点
 */


import structure.LinkedList.ListNode;

/**
 * 这个链表在我们眼里其实也就三个节点：head、head.next、已处理完的链表部分。
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        //当链表到终点或只剩1个节点时，结束递归
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        //对head和next后的节点进行交换，head指向后面的节点
        head.next = swapPairs(next.next);
        //next指向head
        next.next = head;
        //最后的next就是头节点
        return next;
    }
}
