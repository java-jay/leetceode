package algorithm.dynamic;

/**
 * 70.爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStairs {

    /**
     * 斐波那契数列
     * 复杂度：O（logn）
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        //根号5
        double sqrt_5 = Math.sqrt(5);
        //本题为f(1)=1,f(2)=2,相当于从数列的第二项开始，所以要n+1
        double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2, n + 1);
        return (int) (fib_n / sqrt_5);
    }


    /**
     * 记忆化递归
     * 复杂度：O(N)
     */
    public int climbStairs2(int n) {
        int memo[] = new int[n + 1];
        return climbStairs(0, n, memo);
    }

    public int climbStairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climbStairs(i + 1, n, memo) + climbStairs(i + 2, n, memo);
        return memo[i];
    }

    /**
     * 第 i 阶可以由以下两种方法得到：
     * 在第 (i−1) 阶后向上爬一阶。
     * 在第 (i−2)阶后向上爬 2 阶。
     * 所以到达第 i 阶的方法总数为第(i−1)阶和第(i−2)阶的方法数之和。
     * dp[i]=dp[i−1]+dp[i−2]
     */
    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        //最终返回dp[n]，所以dp[0]不存值
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}