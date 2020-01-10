package structure.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * @Auther java_jay
 * @Date 2020/1/10
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
