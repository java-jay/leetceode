package algorithm.math;

/**
 * 628. 三个数的最大乘积
 * @Auther java_jay
 * @Date 2019/12/28
 */
public class MaximumProduct {
    public static void main(String[] args) {
        int[] nums = {-2, -3, 2, 4};
        new MaximumProduct().maximumProduct(nums);
    }

    //线性扫描
    public int maximumProduct(int[] nums) {
        //min1：最小的值，min2：第二小的值
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        //max1：最大的值，max2：第二大的值，max3：第三大的值
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n : nums) {
            //n是最小的值
            if (n < min1) {
                min2 = min1;
                min1 = n;
            //n是第二小的值
            } else if (n < min2) {
                min2 = n;
            }
            //n是最大值
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            //n是第二大的值
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            //n是第三大的值
            } else if (n > max3) {
                max3 = n;
            }
        }
        //最小的两个值（有可能是负数）*最大的值和最大的三个值进行比较
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
