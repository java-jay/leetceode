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
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(1);
        treeNode.right=new TreeNode(2);
        treeNode.right.right=new TreeNode(2);
        new FindMode().findMode(treeNode);
    }

    //存放作为众数的元素
    private List<Integer> list = new ArrayList<>();

    //记录当前数字出现次数
    private int curCount = 1;

    //记录众数的出现次数
    private int maxCount = 1;

    //中序遍历到的上一个节点
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

    //中序遍历
    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        //如果这个节点与遍历到的上一个节点相等
        if (preOrder != null) {
            if (node.val == preOrder.val) {
                curCount++;
            } else {
                curCount = 1;
            }
        }
        //如果众数更新
        if (curCount > maxCount) {
            maxCount = curCount;
            //集合清零
            list.clear();
            //加入当前节点
            list.add(node.val);
        } else if (curCount == maxCount) {
            //如果为众数，加入当前节点
            list.add(node.val);
        }
        preOrder = node;
        inOrder(node.right);
    }
}

