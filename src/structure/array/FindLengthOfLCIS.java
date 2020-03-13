package structure.array;

/**
 * 674. 最长连续递增序列
 */
public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int ans = 1, tmp = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                tmp++;
            } else {
                tmp = 1;
            }
            ans = ans > tmp ? ans : tmp;
        }
        return ans;
    }
}
