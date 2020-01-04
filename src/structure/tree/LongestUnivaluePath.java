package structure.tree;

/**
 * 687. 最长同值路径
 *
 * @Auther java_jay
 * @Date 2020/1/4
 */
public class LongestUnivaluePath {
    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }

    /**
     * 从下到上相加，有三种情况
     * 1.在左子树内部
     * 2.在右子树内部
     * 3.在穿过左子树，根节点，右子树的一条路径中
     */
    public int arrowLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        //第一次到达这里，是叶子节点的上一层节点，如果左子节点和自己相等，边长度+1
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        //因为路径可以穿过根节点，所以是左边长度+右边长度
        ans = Math.max(ans, arrowLeft + arrowRight);
        //将自身的路径层数返回给上一层节点
        return Math.max(arrowLeft, arrowRight);
    }
}
