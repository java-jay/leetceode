package algorithm.dynamic;

/**
 * 198. 打家劫舍
 * 动态规划
 * 由于不可以在相邻的房屋闯入，所以在当前位置n房屋可盗窃的最大值，
 * 要么就是n-1房屋可盗窃的最大值，要么就是n-2房屋可盗窃的最大值加上当前房屋的值，二者之间取最大值
 * dp[n] = MAX( dp[n-1], dp[n-2] + num )
 */
public class Rob {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        //因为要i-2，所以要长度再加1
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }
}
