package structure.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 *
 * @Auther java_jay
 * @Date 2020/1/10
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() != nums.length;
    }
}
