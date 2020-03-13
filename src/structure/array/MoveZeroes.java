package structure.array;

/**
 * 283. 移动零
 * @Auther java_jay
 * @Date 2020/1/11
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[i++] = num;
            }
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
}
