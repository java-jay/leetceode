package structure.tree;

/**
 * 226. 翻转二叉树
 *
 * @Auther java_jay
 * @Date 2020/1/1
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
