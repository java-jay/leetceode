package structure.tree;

/**
 * 687. 最长同值路径
 *
 * @Auther java_jay
 * @Date 2020/1/4
 */
public class LongestUnivaluePath {
    private int count;

    public int longestUnivaluePath(TreeNode root) {
        depth(root);
        return count;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        int arrowLeft = 0, arrowRight = 0;
        //如果左子节点和自己相等，边长度+1
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right;
        }
        count = Math.max(count, arrowLeft + arrowRight);
        //只返回符合条件的长度
        return Math.max(arrowLeft, arrowRight) + 1;
    }
}
