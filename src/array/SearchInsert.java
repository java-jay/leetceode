package array;

/**
 * 35. 搜索插入位置
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        //如果比第一个值小或者相等
        if (target <= nums[0]) return 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //如果等于当前值
            if (target == nums[i]) return i;
            //插到中间
            if (target > nums[i] && target <= nums[i + 1]) return i + 1;

        }
        return nums.length;
    }

    /**
     * 二分查找
     */
    public int searchInsert2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
