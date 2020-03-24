package structure.tree;

/**
 * 530. 二叉搜索树的最小绝对差
 * 先进行中序遍历，得到的结果是递增的，所以依次进行当前节点-前一个节点，找出最小值
 *
 * @Auther java_jay
 * @Date 2020/1/8
 */
public class GetMinimumDifference {
    private TreeNode preOrder = null;

    private int minValue = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minValue;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        if (preOrder != null) {
            minValue = Math.min(minValue, node.val - preOrder.val);
        }
        preOrder = node;
        inOrder(node.right);
    }
}
