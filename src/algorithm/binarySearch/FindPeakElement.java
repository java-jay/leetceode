package algorithm.binarySearch;

/**
 * 162. 寻找峰值
 * 二分查找
 * 题目描述中出现了nums[-1] = nums[n] = -∞，
 * 这就代表着只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值
 *
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[mid+1]){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}
