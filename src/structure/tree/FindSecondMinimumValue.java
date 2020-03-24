package structure.tree;

/**
 * 671. 二叉树中第二小的节点
 *
 * @Auther java_jay
 * @Date 2020/1/4
 */
public class FindSecondMinimumValue {
    /**
     * 因为父节点一定不大于子节点，所以分为3种情况：
     * 1.父节点与两个子节点都不相等（1，2,3），那么较小的子节点为所求节点
     * 2.父节点与一个子节点相等，与另一个子节点不相等（1,1,2），那么较大的子节点为所求节点
     * 3.父节点与两个子节点相等，返回-1
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return -1;
        }
        //左节点和右节点
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        //如果与左节点相等，就重新赋值左节点的值，会变成一个更大的值或者-1
        if (leftVal == root.val) {
            leftVal = findSecondMinimumValue(root.left);
        }
        //如果与右节点相等，就重新赋值右节点的值
        if (rightVal == root.val) {
            rightVal = findSecondMinimumValue(root.right);
        }
        //返回较小的节点
        if (leftVal != -1 && rightVal != -1) {
            return Math.min(leftVal, rightVal);
        }
        //如果左节点不为-1
        if (leftVal != -1) {
            return leftVal;
        }
        //如果左节点为-1
        return rightVal;
    }
}
