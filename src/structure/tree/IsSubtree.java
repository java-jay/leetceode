package structure.tree;

/**
 * @Auther java_jay
 * @Date 2020/1/3
 */
public class IsSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            return isEqual(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        // 当前节点不同，就直接跳到下一节点进行判断
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    //判断s的子树是否和t相等
    private boolean isEqual(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;//两树均空自然相等
        }
        if (l == null || r == null) {
            return false;//一空一非空，自然不等
        }
        if (l.val == r.val)//递归判断
        {
            return isEqual(l.left, r.left) && isEqual(l.right, r.right);
        }
        return false;
    }
}
