package algorithm.grid;

/**
 * 665. 非递减数列
 */
public class CheckPossibility {
    public boolean checkPossibility(int[] nums) {
        if (nums.length < 3) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找到第一个<前一个数的值
            if (nums[i + 1] < nums[i]) {
                //如果有至少2个数需要修改，就直接返回false
                count++;
                if (count > 1) {
                    return false;
                }
                //如果i+1的值同时小于i-1的值和i的值，让i+1的值与i的值相等，确保修改后的大值仍然比后续的值小
                if (i > 0 && nums[i + 1] < nums[i - 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }
}
