package structure.tree;

/**
 * 538. 把二叉搜索树转换为累加树
 *
 * @Auther java_jay
 * @Date 2020/1/7
 */
public class    ConvertBST {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traver(root);
        return root;
    }

    /**
     * 右下角值最大，左下角值最小，所以先向右递归，再从右下角的点开始加起
     * 最后把右子节点的和赋值给根节点
     * 然后再向左递归，从第一个左子节点开始加起
     *
     * @param root
     */
    private void traver(TreeNode root) {
        if (root == null) {
            return;
        }
        traver(root.right);
        sum += root.val;
        root.val = sum;
        traver(root.left);
    }
}
