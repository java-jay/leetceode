package tree;

/**
 * 96. 不同的二叉搜索树
 */
public class NumTrees {
    /**
     * 动态规划
     * <p>
     * 假设n个节点存在二叉排序树的个数是G(n)，令f(i)为以i为根的二叉搜索树的个数
     * G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
     * <p>
     * 当i为根节点时，其左子树节点个数为i-1个，右子树节点为n-i
     * f(i)=G(i−1)∗G(n−i)
     * <p>
     * G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        //i是当时的节点数
        for (int i = 2; i < n + 1; i++) {
            //j是根节点的值，最大值为节点的个数
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
