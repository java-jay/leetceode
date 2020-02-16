package structure.bitwise;

/**
 * 268. 缺失数字
 *
 * @Auther java_jay
 * @Date 2020/1/13
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        //因为原来有nums.length+1个数
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
