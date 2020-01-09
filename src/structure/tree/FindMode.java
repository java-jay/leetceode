package structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 *
 * @Auther java_jay
 * @Date 2020/1/8
 */
public class FindMode {
    private List<Integer> list = new ArrayList<>();//存放作为众数的元素
    private int curCount = 1;//记录当前数字出现次数
    private int maxCount = 1;//记录众数的出现次数
    private TreeNode preOrder = null;

    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] result = new int[list.size()];
        int index = 0;
        for (int num : list) {
            result[index++] = num;
        }
        return result;
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        if (preOrder != null) {
            if (node.val == preOrder.val) {
                curCount++;
            } else {
                curCount = 1;
            }
        }
        if (curCount > maxCount) {//如果之前记录的不为众数
            maxCount = curCount;
            list.clear();//集合清零
            list.add(node.val);//加入当前节点
        } else if (curCount == maxCount) {
            list.add(node.val);//加入当前节点
        }
        preOrder = node;
        inOrder(node.right);
    }
}

