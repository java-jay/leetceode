package structure.tree;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //如果都没有节点了，说明全部一致
        if (p == null && q == null) {
            return true;
        }
        //说明有一方还有节点
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
