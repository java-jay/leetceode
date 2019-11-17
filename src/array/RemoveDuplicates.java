package array;

/**
 * 26. 删除排序数组中的重复项
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        removeDuplicates.removeDuplicates(new int[]{1, 1, 1, 2});
    }

    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {//不等于的时候，说明没有重复值，数组长度才可以+1
                i++;
                nums[i] = nums[j];//为了覆盖重复值,把右边的非重复值挪到左边来替代重复值
            }
        }
        return i + 1;//因为是返回数组长度，所以最后要+1
    }
}
