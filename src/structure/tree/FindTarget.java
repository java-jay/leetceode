package structure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 653. 两数之和 IV - 输入 BST
 * 先进行中序遍历，得到的结果是递增数组，再进行双指针查找
 * @Auther java_jay
 * @Date 2020/1/8
 */
public class FindTarget {
    private List<Integer> nums=new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        inOrder(root);
        int i=0,j=nums.size()-1;
        while(i<j){
            int sum=nums.get(i)+nums.get(j);
            if(sum==k) return true;
            else if(sum<k) i++;
            else j--;
        }
        return false;
    }
    private void inOrder(TreeNode node){
        if(node==null) return ;
        inOrder(node.left);
        nums.add(node.val);
        inOrder(node.right);
    }
}
