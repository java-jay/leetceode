package algorithm.slidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. 存在重复元素 II
 * 判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值不超过 k。
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * <p>
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class ContainsNearbyDuplicate {
    /**
     * 散列表，滑动窗口
     * 每次加入元素前判断是否有重复，如果有，就返回true，如果没有就加入集合
     * 因为距离不能大于k，所以每次集合长度大于k时，就把集合最前面的元素删掉
     * 通过控制集合长度，保证距离差永远小于等于k
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 0, j = 0, n = nums.length;
        Set<Integer> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(nums[j])) {
                set.add(nums[j++]);
            } else {
                if (j - i <= k) {
                    return true;
                } else {
                    set.remove(nums[i++]);
                }
            }
        }
        return false;
    }
}
