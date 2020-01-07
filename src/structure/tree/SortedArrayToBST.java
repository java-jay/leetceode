package structure.tree;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * @Auther java_jay
 * @Date 2020/1/7
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10, 3, 0, 5, 9};
        new SortedArrayToBST().sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length - 1);
    }

    /**
     * 二分法
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private TreeNode toBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int middle = left + (right - left) >> 1;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = toBST(nums, left, middle - 1);
        node.right = toBST(nums, middle + 1, right);
        return node;
    }
}
