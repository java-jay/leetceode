package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combine {
    public static void main(String[] args) {
        Combine combine = new Combine();
        combine.combine(4, 2);
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
        //n-k+1的含义是：当前这层方法所代表的数能增长到的最大值
        //例如n=4，k=2，顺序为1,2 1,3 1,4 2,3 2,4 3,4
        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            //集合还能容纳的数字-1，后续数字前进1
            getCombine(n, k - 1, i + 1, list);
            //集合已被添加，去除最后一个节点，准备下一次循环，例如1,2将2删除，才能再添加3，变为1,3
            list.remove(list.size() - 1);
        }
    }
}
