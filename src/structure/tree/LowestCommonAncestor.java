package structure.tree;

/**
 * 235. 二叉搜索树的最近公共祖先
 *
 * @Auther java_jay
 * @Date 2020/1/7
 */
public class LowestCommonAncestor {

    //二叉搜索树的公共祖先一定介于两个指定节点的值之间
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
