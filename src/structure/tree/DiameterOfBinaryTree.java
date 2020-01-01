package structure.tree;

/**
 * 543. 二叉树的直径
 * 两结点之间的路径长度是以它们之间边的数目表示。
 *
 * @Auther java_jay
 * @Date 2020/1/1
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(1);
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(t1));
    }

    private int count;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return count;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int L = depth(node.left);
        int R = depth(node.right);
        count = Math.max(count, L + R);
        return Math.max(L, R) + 1;
    }
}
