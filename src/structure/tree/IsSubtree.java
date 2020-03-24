package structure.tree;

/**
 * @Auther java_jay
 * @Date 2020/1/3
 */
public class IsSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        /*
         t就等于s本身
         t是s的左子树的子树
         t是s的右子树的子树
         */
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            //如果当前节点相等，但子节点不相等，就对子节点继续递归
            return isEqual(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        // 当前节点不同，就直接跳到下一节点进行判断
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    /**
     * 判断s的子树是否和t相等
     * 根节点值相等
     * l的左子树和r的左子树相等
     * l的右子树和r的右子树相等
     */
    private boolean isEqual(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            //两树均空自然相等
            return true;
        }
        if (l == null || r == null) {
            //一空一非空，自然不等
            return false;
        }
        //递归判断
        if (l.val == r.val) {
            return isEqual(l.left, r.left) && isEqual(l.right, r.right);
        }
        return false;
    }
}
