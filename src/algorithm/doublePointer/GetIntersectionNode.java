package algorithm.doublePointer;

/**
 * @Auther java_jay
 * @Date 2019/12/30
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        //A:3-5-8,B:3-8,交叉点是8
        ListNode headA = new ListNode(3);
        headA.next = new ListNode(5);
        ListNode cross = new ListNode(8);
        headA.next.next = cross;
        ListNode headB = new ListNode(3);
        headB.next = cross;
        ListNode intersectionNode = new GetIntersectionNode().getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);
    }

    //追赶问题，每到达链表的结尾，就到另一条链表的开头（自己的路走完了，沿着他的路往前追），继续追赶，直到相遇
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA, hb = headB;
        while (ha != hb) {
            ha = ha != null ? ha.next : headB;
            hb = hb != null ? hb.next : headA;
        }
        return ha;
    }
}
