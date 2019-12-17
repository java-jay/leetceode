package algorithm.binarySearch;

/**
 * 4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
public class findMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 4, 9};
        int[] nums2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double medianSortedArrays = findMedianSortedArrays4(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    /**
     * 归并解法
     * 创建一个新数组，按顺序存放数字，然后从新数组中求中位数
     * 时间复杂度：遍历全部数组 (m+n)
     * 空间复杂度：开辟了一个数组，保存合并后的两个数组 O(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        if (m == 0) {
            //如果n是偶数
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }

    /**
     * 通过A[aStart] < B[bStart]判断两个数组中当前数的大小，进而实现从小到大查找数
     *
     * @param A
     * @param B
     * @return
     */
    public static double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        //求出数组总长度
        int len = m + n;
        //right为新到达的数，left为上一次right到达的数，每次right走之前，先把值赋给left
        int left = -1, right = -1;
        //作为数组的指针
        int aStart = 0, bStart = 0;
        //求中位数的遍历次数：（n/2）+1次，比如6个就要遍历4次
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            //如果（左指针还没遍历完）且（（右指针遍历完）或（数组1的当前数小于数组2的当前数））
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                //right到达数组1的下一个数
                //左指针右移
                right = A[aStart++];
            } else {
                //right到达数组2的下一个数
                //右指针右移
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0)//偶数的末尾才是0
            return (left + right) / 2.0;
        else
            return right;
    }

    /**
     * 通过二分法，找到第k小的数，即为中位数
     * 时间复杂度：每进行一次循环，我们就减少 k/2 个元素，所以时间复杂度是 O(log(k)，而 k=(m+n)/2，所以最终的复杂也就是 O(log(m+n）。
     *
     * 空间复杂度：虽然我们用到了递归，但是可以看到这个递归属于尾递归，所以编译器不需要不停地堆栈，所以空间复杂度为 O(1)。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;//中位数的左值
        int right = (n + m + 2) / 2;//中位数的右值
        //求中位数，左值+右值相加/2，如果是奇数，左值是等于右值的
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    //k是左值或右值，该方法要求得第k个数，传过来的值end和start是索引值
    private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        //当前数组1的长度,n-1+1=n
        int len1 = end1 - start1 + 1;
        //当前数组2的长度
        int len2 = end2 - start2 + 1;

        //如果数组1长度大于数组2，就让数组1和数组2的顺序颠倒，保证数组1长度小于数组2
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        //如果数组1长度等于0，就返回数组2的第k个值
        if (len1 == 0) return nums2[start2 + k - 1];
        //如果k=1，返回两个数组中的最小值
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        //数组1和数组2的第k/2的索引,如果k/2大于数组长度，则让指针指向数组最后一个数
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        //哪个小，它的前k/2个数字都不是第 k 小数字，排除前k/2个数字
        if (nums1[i] > nums2[j]) {
            //数组2的前j+1个值舍去
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            //数组1的前i+1个值舍去
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    /**
     * @param A
     * @param B
     * @return
     */
    public static double findMedianSortedArrays4(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedianSortedArrays(B, A); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && B[j - 1] > A[i]) { // i 需要增大
                iMin = i + 1;
            } else if (i != 0 && j != n && A[i - 1] > B[j]) { // i 需要减小
                iMax = i - 1;
            } else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
    }

}
