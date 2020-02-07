package structure.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {5, 4, 1, 3, 2};
        System.out.println(new LongestConsecutive().longestConsecutive2(nums));
    }
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            //如果num-1存在，直接进行下一次循环，目的是为了找到连续数字中最小的数
            if (!set.contains(num - 1)) {
                int count = 0;
                //直到连续数字的开头，才会进入循环，直到连续数字的结尾，才会退出循环
                while (set.contains(num)) {
                    count++;
                    num ++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public int longestConsecutive2(int[] nums) {
        //哈希表存放的是，每个元素对应的连续序列的长度
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            //找到左边界，默认为 0
            int left = map.getOrDefault(num - 1, 0);
            //找到右边界，默认为 0
            int right = map.getOrDefault(num + 1, 0);
            int sum = left + 1 + right;
            max = Math.max(max, sum);

            map.put(num, sum);
            //更新左边界长度
            map.put(num - left, sum);
            //更新右边界长度
            map.put(num + right, sum);
        }
        return max;
    }
}
