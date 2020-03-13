package algorithm.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.三数之和
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        //如果不达3个数字，直接返回空集合
        if (len < 3) {
            return list;
        }
        //对数组进行排序，从小到大，判断当前值+左指针+右指针是否为0
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            //如果当前值大于0，说明右边都大于0，直接跳出循环
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                //这个数为开头的情况，前面已经考虑过，不用再考虑
                continue;
            }
            //左指针和右指针
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                //求三数之和
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //如果后面还有相等的值，可以直接不用考虑
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }
}
