package structure.string;

/**
 * 409. 最长回文串
 *
 * @Auther java_jay
 * @Date 2020/1/10
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] arr = new int[256];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }
        //回文字符串的长度
        int ans = 0;
        for (int i : arr) {
            //如果为偶数，代表元素可以放在两侧，如果为奇数，就要扣减一个元素，再放到两侧
            //奇数/2*2相当于-1
            ans += (i / 2) * 2;
        }
        //如果回文字符串长度小于字符串长度，说明有一个只出现一次的元素可以放中间
        if (ans < s.length()) {
            // 这个条件下 s 中一定有单个未使用的字符存在，可以把这个字符放到回文的最中间
            ans++;
        }
        return ans;
    }
}
