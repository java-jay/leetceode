package algorithm.doublePointer;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 从有值的地方开始，右往左遍历，把大的值赋到最后去，当一个数组没有值后，就把另一个数组剩余的值拷过来
 */
public class mergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;//数组1的最后索引
        while (len1 >= 0 && len2 >= 0) {
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        //将num2的从索引0开始，长度len2+1的值，拷到num1中，从num1索引开始
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }


}
