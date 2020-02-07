package structure.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 594. 最长和谐子序列
 * @Auther java_jay
 * @Date 2020/1/10
 */
public class FindLHS {
    public static void main(String[] args) {
        int[] nums={1,3,2,2,5,2,3,7};
        new FindLHS().findLHS(nums);
    }

    /**
     * 哈希映射
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();
        //获取每个数出现的次数
        for (int num : nums) {
            countForNum.put(num, countForNum.getOrDefault(num, 0) + 1);
        }
        int longest = 0;
        //遍历map的键
        for (int num : countForNum.keySet()) {
            //如果map中还包含了比这个键大1的键，就把这两个键的值加起来，当做最长长度
            if (countForNum.containsKey(num + 1)) {
                longest = Math.max(longest, countForNum.get(num + 1) + countForNum.get(num));
            }
        }
        return longest;
    }

    /**
     * 哈希映射 + 单次扫描，可以不用先把所有的数存到哈希表中
     * @param nums
     * @return
     */
    public int findLHS2(int[] nums) {
        HashMap < Integer, Integer > map = new HashMap <> ();
        int res = 0;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num + 1)) {
                res = Math.max(res, map.get(num) + map.get(num + 1));
            }
            if (map.containsKey(num - 1)) {
                res = Math.max(res, map.get(num) + map.get(num - 1));
            }
        }
        return res;
    }
}
