package structure.tree;

/**
 * 110. 判断是否为平衡二叉树
 */
public class BalancedTree {

    public boolean isBalanced(TreeNode root) {
        return isBST(root).isBalance;
    }

    private ReturnNode isBST(TreeNode root) {
        if (root == null) {
            return new ReturnNode(true, 0);
        }
        ReturnNode left = isBST(root.left);
        ReturnNode right = isBST(root.right);
        //不平衡的情况有3种：左树不平衡、右树不平衡、左树和右树差的绝对值大于1
        if (!left.isBalance || !right.isBalance) {
            return new ReturnNode(false, 0);
        }
        if (Math.abs(left.length - right.length) > 1) {
            return new ReturnNode(false, 0);
        }
        return new ReturnNode(true, Math.max(left.length, right.length) + 1);
    }

    private class ReturnNode {
        boolean isBalance;
        int length;

        ReturnNode(boolean isBalance, int length) {
            this.isBalance = isBalance;
            this.length = length;
        }
    }

}
