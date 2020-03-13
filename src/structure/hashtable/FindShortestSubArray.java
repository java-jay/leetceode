package structure.hashtable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度
 *
 * @Auther java_jay
 * @Date 2020/1/13
 */
public class FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        //数字的出现次数
        Map<Integer, Integer> count = new HashMap<>();
        //每个数最后出现的索引
        Map<Integer, Integer> firstIndex = new HashMap<>();
        //每个数第一次出现的索引
        Map<Integer, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            count.put(num, count.getOrDefault(num, 0) + 1);
            lastIndex.put(num, i);
            if (!firstIndex.containsKey(num)) {
                firstIndex.put(num, i);
            }
        }
        //获取出现次数最多的数字
        int maxCount = Collections.max(count.values());
        int ans = nums.length;
        for (int num : nums) {
            //只需要获取每个数字的最后索引-初始索引的最小值，不用获取每个子数组
            if (count.get(num) == maxCount) {
                ans = Math.min(ans, lastIndex.get(num) - firstIndex.get(num) + 1);
            }
        }
        return ans;
    }
}
