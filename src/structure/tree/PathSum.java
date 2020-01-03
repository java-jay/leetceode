package structure.tree;

/**
 * 437. 路径总和 III，还有一种双重递归的解法
 *
 * @Auther java_jay
 * @Date 2020/1/2
 */
public class PathSum {

    public int pathSum(TreeNode root, int sum) {
        //因为题目规定二叉树不超过1000个节点，所以构建一个1000个数的数组
        //0表示第一层节点
        return pathSum(root, sum, new int[1000], 0);
    }

    public int pathSum(TreeNode root, int sum, int[] array, int p) {
        if (root == null) {
            return 0;
        }
        //保存当前节点的值到数组中
        array[p] = root.val;
        int tmp = 0;
        //统计路径数
        int n =  0;
        //遍历数组，进行相加，如果结果等于目标结果，路径数加1。从树下方往上相加
        for (int i = p ; i >= 0; i--) {
            tmp += array[i];
            if (tmp == sum) {
                //因为有负数的存在，所以不能使用break，要全部循环完
                n++;
            }
        }
        //遍历下一层节点
        int left = pathSum(root.left, sum, array, p + 1);
        int right = pathSum(root.right, sum, array, p + 1);
        return n + left + right;
    }
}
