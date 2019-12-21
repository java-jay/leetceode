package structure.array;

/**
 * 152. 乘积最大子序列
 * 动态规划
 * imax表示以当前节点为终结节点的最大连续子序列乘积 imin表示以当前节点为终结节点的最小连续子序列乘积
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        //因为数组中存在负数，负数*最大值会变成最小值，所以要调换顺序
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);
            max = Math.max(imax, max);
        }
        return max;
    }
}
