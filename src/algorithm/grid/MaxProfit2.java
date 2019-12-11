package algorithm.grid;

public class MaxProfit2 {
    public static void main(String[] args) {
        MaxProfit2 maxProfit2 = new MaxProfit2();
        System.out.println(maxProfit2.maxProfit(new int[]{7, 1, 5, 3, 4, 6}));
    }
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            //只要后面的数更大，利润就加上这个差值，最后总是最大的值-最小的值，例如（b-a）+（c-b）=c-a
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
}
