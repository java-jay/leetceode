package structure.array;

/**
 * 645. 错误的集合
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/set-mismatch/solution/cuo-wu-de-ji-he-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FindErrorNums {
    /**
     * 如果是第一次访问，将它转为负数
     * 如果访问时已经是负数，说明他是重复数
     * 最后只有缺失数字 对应的索引仍然是正数
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        //重复数和缺失数
        int dup = 0 , missing = 0;
        for (int n : nums) {
            if (nums[Math.abs(n) - 1] < 0) {
                dup = Math.abs(n);
            } else {
                nums[Math.abs(n) - 1] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }
        return new int[]{dup, missing};
    }
}
