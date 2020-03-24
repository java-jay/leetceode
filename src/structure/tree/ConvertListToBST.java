package structure.tree;

import structure.LinkedList.ListNode;

/**
 * 109. 有序链表转换二叉搜索树
 *
 * @Auther java_jay
 * @Date 2020/3/23
 */
public class ConvertListToBST {
    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(-15);
        ListNode listNode = new ListNode(-10);
        listNode2.next=listNode;
        listNode.next=new ListNode(-3);
        listNode.next.next=new ListNode(0);
        listNode.next.next.next=new ListNode(5);
        listNode.next.next.next.next=new ListNode(9);
        listNode.next.next.next.next.next=new ListNode(15);
        TreeNode treeNode = new ConvertListToBST().sortedListToBST(listNode2);
        System.out.println(treeNode);
    }
    private ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        //获取链表的节点个数
        int size = this.getSize(head);
        //标记头节点
        this.head = head;
        return convertListToBST(0, size - 1);
    }

    private int getSize(ListNode head) {
        ListNode node = head;
        int c = 0;
        while (node != null) {
            node = node.next;
            c++;
        }
        return c;
    }

    private TreeNode convertListToBST(int l, int r) {
        if (l > r) {
            return null;
        }
        int middle = (l + r) >>> 1;
        TreeNode left = convertListToBST(l, middle - 1);
        //第一次执行该语句时，head为链表的第一个节点，left为空
        TreeNode node = new TreeNode(head.val);
        node.left = left;
        //遍历到链表的下一节点
        head = head.next;
        node.right = convertListToBST(middle + 1, r);
        return node;
    }


}
