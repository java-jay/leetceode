package structure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 *
 * @Auther java_jay
 * @Date 2020/1/6
 */
public class FindBottomLeftValue {
    /**
     * BFS
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //替换root，这样最后就可以直接返回root，而不用重新设计一个变量
            root = queue.poll();
            if (root.right != null) {
                queue.add(root.right);
            }
            //通过队列，最后一次添加的left节点也是最后一次被删除的
            if (root.left != null) {
                queue.add(root.left);
            }
        }
        return root.val;
    }

    /**
     * DFS
     */
    //结果值
    private int ans = -1;

    //记录当前最大高度
    private int max = -1;

    public int findBottomLeftValue2(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int h) {
        if (root == null) {
            return;
        }
        //只有到叶子节点才进行替换
        if (root.left == null && root.right == null) {
            //保证只会拿每一层的最左节点的值进行替换
            if (h > max) {
                max = h;
                ans = root.val;
            }
        }
        dfs(root.left, h + 1);
        dfs(root.right, h + 1);
    }
}
