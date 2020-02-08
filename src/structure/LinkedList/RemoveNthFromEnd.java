package structure.LinkedList;

/**
 * 19. 删除链表的倒数第N个节点
 * start先到第n个节点
 * start继续前进，end开始前进，start到尾部时，end+1的位置恰好为倒数第n个节点
 * 例如：有6个节点，要删除倒数第2个节点，6-2=4，end就在第4个节点
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //头节点
        ListNode pre = new ListNode(0);
        pre.next = head;
        //快慢指针是从头节点开始的
        ListNode fast = pre, slow = pre;
        //快指针移到正数第n个节点
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        //同时移动快指针和慢指针，直到快指针到达最后一个节点，也就是快指针又移动了l-n个节点（l为总长度）
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //这时慢指针在第l-n个节点，也就是倒数第n+1个节点
        slow.next = slow.next.next;
        //有可能head也会被删除，所以要返回pre的下一个节点
        return pre.next;
    }
}
