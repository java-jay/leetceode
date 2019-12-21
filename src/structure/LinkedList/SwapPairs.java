package structure.LinkedList;

/**
 * 24. 两两交换链表中的节点
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

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
        head.next = swapPairs(next.next);//对head和next后的节点进行交换，head指向后面的节点
        next.next = head;//next指向head
        return next;//最后的next就是头节点
    }
}
