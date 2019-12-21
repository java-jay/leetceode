package structure.array;

import java.util.HashSet;

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
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) set.remove(nums[i - k]);
        }
        return false;
    }
}
