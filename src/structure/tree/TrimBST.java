package structure.tree;

/**
 * 669. 修剪二叉搜索树
 *
 * @Auther java_jay
 * @Date 2020/1/7
 */
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        //因为是二叉搜索树，左节点比根节点大，右节点比根节点小，所以如果根节点大于最大边界，就往左找
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
