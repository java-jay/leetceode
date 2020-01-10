package structure.string;

/**
 * 409. 最长回文串
 *
 * @Auther java_jay
 * @Date 2020/1/10
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] cnts = new int[256];
        for (char c : s.toCharArray()) {
            cnts[c]++;
        }
        //回文字符串的长度
        int palindrome = 0;
        for (int cnt : cnts) {
            //如果为偶数，就放在两侧，如果为奇数，就省去
            palindrome += (cnt / 2) * 2;
        }
        //如果回文字符串长度小于字符串长度，说明有一个只出现一次的元素可以放中间
        if (palindrome < s.length()) {
            palindrome++;   // 这个条件下 s 中一定有单个未使用的字符存在，可以把这个字符放到回文的最中间
        }
        return palindrome;
    }
}
