package algorithm.dynamic;

public class NumArray {
    private int[] sum;
    //构建数组和
    public NumArray(int[] nums) {
        //nums[i]是当前数，sum[i+1]是从第一个数到当前数的总和
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
