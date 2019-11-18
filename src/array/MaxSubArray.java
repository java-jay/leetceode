package array;

/**
 *
 */
public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        maxSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }

    /**
     * 动态规划
     * 让sum从头加到尾，当sum是负数时，则不进行相加，直接赋值（因为这时候sum对最终结果无增益效果，可直接丢弃）
     * 在每次循环的最后判断ans和sum谁大，再赋给ans，就是当前遍历到的最长的子串长度
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int ans=nums[0];
        int sum=0;
        for (int num : nums) {
            if(sum>0){
                sum+=num;
            }else{
                sum=num;
            }
            ans=Math.max(sum,ans);
        }
        return ans;
    }
}
