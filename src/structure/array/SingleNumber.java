package structure.array;

/**
 * 136. 只出现一次的数字
 * 异或:a⊕b⊕a =b
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans=0;
        for (int num : nums) {
            ans^=num;
        }
        return ans;
    }
}
