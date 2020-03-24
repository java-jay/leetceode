package structure.tree;

/**
 * 96. 不同的二叉搜索树
 */
public class NumTrees {
    /**
     * 动态规划
     * 假设i个节点组成的二叉搜索树的个数是G(i)，f(j)为以j为根的二叉搜索树的个数
     * G(i)=f(1)+f(2)+f(3)+f(4)+...+f(i)
     * 当j为根节点时，其左子树节点个数为j-1个，右子树节点为i-j个
     * f(j)=G(j−1)∗G(i−j)
     * G(i)=G(0)∗G(i−1)+G(1)∗(i−2)+...+G(i−1)∗G(0)
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        //0个节点和1个节点时，只有1个二叉搜索树
        dp[0] = 1;
        dp[1] = 1;
        //i是节点数
        for (int i = 2; i <= n; i++) {
            //j是根节点的值
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
