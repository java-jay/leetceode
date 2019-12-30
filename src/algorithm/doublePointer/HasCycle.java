package algorithm.doublePointer;

/**
 * 141. 环形链表
 */

class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            //快的去追慢的，如果能追上，说明有环
            fast = fast.next.next;
        }
        return true;
    }
}
