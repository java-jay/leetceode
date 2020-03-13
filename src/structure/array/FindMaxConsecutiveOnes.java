package structure.array;

/**
 * 485. 最大连续1的个数
 *
 * @Auther java_jay
 * @Date 2020/1/12
 */
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, tmp = 0;
        for (int num : nums) {
            if (num == 1) {
                tmp++;
            } else {
                tmp = 0;
            }
            ans = ans > tmp ? ans : tmp;
        }
        return ans;
    }
}
