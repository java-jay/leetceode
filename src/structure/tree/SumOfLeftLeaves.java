package structure.tree;

/**
 * 404. 左叶子之和
 *
 * @Auther java_jay
 * @Date 2020/1/4
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //如果左子节点是叶子节点，就直接加上他的值，再去右子节点找左叶子节点
        if (isLeaf(root.left)) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        //如果左子节点不是叶子节点，就去子节点找
        else {
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }

    public boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }
}
