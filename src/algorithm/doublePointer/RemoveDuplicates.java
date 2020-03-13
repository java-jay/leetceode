package algorithm.doublePointer;

/**
 * 26. 删除排序数组中的重复项
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        removeDuplicates.removeDuplicates(new int[]{1,2});
    }

    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            //不等于的时候，说明没有重复值，数组长度才可以+1
            if (nums[j] != nums[i]) {
                i++;
                //输出的时候是从左到右输出数组的，让后面的值覆盖前面的重复值
                nums[i] = nums[j];
            }
        }
        //因为是返回数组长度，所以最后要+1
        return i + 1;
    }
}
