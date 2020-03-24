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

    //始终选择中间位置的左边元素作为根节点
    private TreeNode toBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (left + right) >>> 1;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = toBST(nums, left, middle - 1);
        node.right = toBST(nums, middle + 1, right);
        return node;
    }

    //始终选择中间位置的右边元素作为根节点
    private TreeNode toBST2(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (left + right) >>> 1;
        //移动到中间位置的右边
        if ((left + right) % 2 == 1) {
            middle++;
        }
        TreeNode node = new TreeNode(nums[middle]);
        node.left = toBST(nums, left, middle - 1);
        node.right = toBST(nums, middle + 1, right);
        return node;
    }
}
