package structure.tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104.二叉树的最大深度
 */

public class MaxDepth {

    /**
     * 递归
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)或O(log(N))(平衡树)
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
//        if(root==null){//递归结束条件，当树为空时
//            return 0;
//        }
//        int leftDepth=maxDepth(root.left);
//        int rightDepth = maxDepth(root.right);
//        return Math.max(leftDepth,rightDepth)+1;//因为有一个根节点，要最后再+1
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 迭代，使用 DFS 策略访问每个结点，同时在每次访问时更新最大深度。
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();//pair：键值对集合
        if (root != null) {//如果节点不为空
            stack.add(new Pair(root, 1));//加入队列中，深度为1
        }

        int depth = 0;
        while (!stack.isEmpty()) {//当队列中有值时
            Pair<TreeNode, Integer> current = stack.poll();//从队首获取元素，同时获取的这个元素将从原队列删除
            root = current.getKey();//获取当前节点
            int current_depth = current.getValue();//获取当前深度
            if (root != null) {
                depth = Math.max(depth, current_depth);//获取最大深度
                stack.add(new Pair(root.left, current_depth + 1));//将左节点加入队列，深度+1
                stack.add(new Pair(root.right, current_depth + 1));//将右节点加入队列，深度+1
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        MaxDepth maxDepth=new MaxDepth();
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(5);
        root.right=new TreeNode(8);
        maxDepth.maxDepth2(root);
    }
}
