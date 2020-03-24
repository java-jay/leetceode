package structure.tree;

/**
 * 938. 二叉搜索树的范围和
 * 求出所有 X >= L 且 X <= R 的值的和
 * 中序遍历
 */
public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        //如果小于最小值，就往右遍历
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        //如果大于最大值，就往左遍历
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        //当前节点+左子树和右子树
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}
