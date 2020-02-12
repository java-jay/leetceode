package algorithm.grid;

/**
 * 121. 买卖股票的最佳时机
 * 遍历数组，找到最小的值，再找和最小值相差最大的值
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                profit = Math.max(prices[i] - min, profit);
            } else {
                min = prices[i];
            }
        }
        return profit;
    }
}
