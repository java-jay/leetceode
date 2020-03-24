package structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. 二叉树的层平均值
 *
 * @Auther java_jay
 * @Date 2020/1/5
 */
public class AverageOfLevels {
    /**
     * 广度优先
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //利用队列的先进先出
        Queue<TreeNode> queue = new LinkedList<>();
        //将根节点加入队列中
        queue.add(root);
        //如果队列不为空
        while (!queue.isEmpty()) {
            //每层的节点个数
            int cnt = queue.size();
            //每层的节点值总和
            double sum = 0;
            //求每层的总和，删除该层的节点，并把下一层节点加入到队列中
            for (int i = 0; i < cnt; i++) {
                //poll方法可以返回要删除的对象，如果要删除的为null，也是返回null，不会报异常
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //将平均数加入到集合中
            list.add(sum / cnt);
        }
        return list;
    }

    /**
     * 深度优先
     */
    public List<Double> averageOfLevels2(TreeNode root) {
        //存储每一层的节点个数
        List<Integer> count = new ArrayList<>();
        //存储每一层的节点总和
        List<Double> ans = new ArrayList<>();
        average(root, 0, ans, count);
        //遍历每层节点，计算平均值
        for (int i = 0; i < ans.size(); i++) {
            ans.set(i, ans.get(i) / count.get(i));
        }
        return ans;
    }

    /**
     * @param node  节点
     * @param i     第i层
     * @param sum   结果集合
     * @param count 该层节点个数
     */
    public void average(TreeNode node, int i, List<Double> sum, List<Integer> count) {
        if (node == null) {
            return;
        }
        //如果不是每一层的第一个节点，就计算总和，且节点个数+1
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + node.val);
            count.set(i, count.get(i) + 1);
        //如果是每一层的第一个节点
        } else {
            //第一个节点加入结果集合，该层节点个数为1
            sum.add(1.0 * node.val);
            count.add(1);
        }
        //遍历到下一层
        average(node.left, i + 1, sum, count);
        average(node.right, i + 1, sum, count);
    }
}
