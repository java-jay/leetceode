package algorithm.grid;

/**
 * 121. 买卖股票的最佳时机
 * 遍历数组，找到最小的值，再找和最小值相差最大的值
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > min) max = Math.max(max, prices[i] - min);
            else min = prices[i];
        }
        return max;
    }
}
