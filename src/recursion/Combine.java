package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combine {
    public static void main(String[] args) {
        Combine combine = new Combine();
        combine.combine(4, 3);
    }

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        getCombine(n, k, 1, new ArrayList<>());
        return ans;
    }

    public void getCombine(int n, int k, int start, List<Integer> list) {
        if (k == 0) {
            //该层递归结束，将其添加到ans中
            ans.add(new ArrayList<>(list));
            return;
        }
        //从1节点开始，对每一个可能进行遍历
        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            getCombine(n, k - 1, i + 1, list);
            //去除最后一个节点，准备下一次循环
            list.remove(list.size() - 1);
        }
    }
}
