package structure.LinkedList;

/**
 * 234.回文链表
 *
 * @Auther java_jay
 * @Date 2019/12/31
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //快慢指针
        ListNode slow = head, fast = head;
        //前节点和前前节点
        ListNode pre = head, prepre = null;
        //将到达回文交界点的部分的链表进行反转，1-2-2-1变为2-1-null
        //pre=2，pre.next=1，pre.next.next=null
        //而slow依旧按原链表继续遍历，当pre=第一个2时，slow=第二个2
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        //当fast在最后一个节点时，说明是奇数个节点，slow在中间的那个节点，需要遍历到下一节点
        if (fast != null) {
            slow = slow.next;
        }
        //因为链表完成了反转，所以如果是回文链表，pre和slow的值是一样的
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
