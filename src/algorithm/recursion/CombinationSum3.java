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
        getCombine(n, k, 0, 1, new ArrayList<>());
        return ans;
    }

    public void getCombine(int n, int k, int sum, int start, List<Integer> list) {
        if (k == 0) {
            if (n == sum)
                ans.add(new ArrayList<>(list));

        } else {
            for (int i = start; i < 10; i++) {
                list.add(i);
                getCombine(n, k - 1, sum + i, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
