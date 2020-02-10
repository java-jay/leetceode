package algorithm.recursion;


import structure.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 */
public class Construct_paths {


    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> list = new LinkedList<>();
        allPaths(root, "", list);
        return list;
    }

    public void allPaths(TreeNode root, String path, LinkedList<String> list) {
        if (root != null) {
            path += root.val;
            //当前节点是叶子节点
            if (root.left == null && root.right == null) {
                //把路径加入到集合中
                list.add(path);
            } else {
                //当前节点不是叶子节点，继续递归
                path += "->";
                allPaths(root.left, path, list);
                allPaths(root.right, path, list);
            }
        }
    }
}
