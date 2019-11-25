package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.三数之和
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        //如果不达3个数字，直接返回空集合
        if (len < 3) return list;
        //对数组进行排序，从小到大，判断当前值+左指针+右指针是否为0
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            //如果当前值大于0，说明右边都大于0，直接跳出循环
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;//去重
            //左指针和右指针
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++;//去重
                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
                    L++;
                    R--;
                } else if (sum < 0) L++;
                else R--;
            }
        }
        return list;

    }
}
