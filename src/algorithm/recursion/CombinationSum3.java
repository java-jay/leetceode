package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。
 * 组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 */
public class CombinationSum3 {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        traceBack(k, n, 0, 1, new ArrayList<>());
        return ans;
    }

    public void traceBack(int k, int n, int sum, int begin, List<Integer> list) {
        //递归终止条件：链表已包含k个数，如果和为n则加入结果集，否则直接返回终止递归
        if (k == 0) {
            if (n == sum)
                ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i < 10; i++) {
            list.add(i);
            //每次剩余个数-1，新的总和，要加入的新数+1
            traceBack(k - 1, n, sum + i, i + 1, list);
            //删除最后一个元素，准备加入新的元素
            list.remove(list.size()-1);
        }
    }
}
