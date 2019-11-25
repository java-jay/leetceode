package LinkedList;

/**
 * 19. 删除链表的倒数第N个节点
 * start先到第n个节点
 * start继续前进，end开始前进，start到尾部时，end+1的位置恰好为倒数第n个节点
 * 例如：有6个节点，要删除倒数第2个节点，6-2=4，end就在第4个节点
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        //判断end要走几次，总节点数-n，就是end最后在的节点
        while (n != 0) {
            start = start.next;
            n--;
        }
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        //有可能head也会被删除，所以要返回pre的下一个节点
        return pre.next;
    }
}
