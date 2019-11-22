package array;

/**
 * 674. 最长连续递增序列
 */
public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int ans = 1;//最大长度
        int count = 1;//当前的最大长度
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i + 1] > nums[i]) count++;
            else count = 1;//重新初始化
            ans = count > ans ? count : ans;
        }
        return ans;
    }
}
