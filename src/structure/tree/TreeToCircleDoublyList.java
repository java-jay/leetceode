package structure.tree;

/**
 * @Auther java_jay
 * @Date 2020/3/22
 */
public class TreeToCircleDoublyList {

    //头节点，前节点，尾节点
    private TreeNode head = null, pre = null, tail = null;

    public TreeNode treeToCircleDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        //中序遍历
        inorder(root);
        //连接头尾节点
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pre == null) {
            //记录头节点
            head = root;
        } else {
            //绑定右指针
            pre.right = root;
        }
        //绑定左指针
        root.left = pre;
        //前指针移动到当前节点
        pre = root;
        //记录尾节点
        tail = root;
        inorder(root.right);
    }
}
