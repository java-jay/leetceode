package math;

/**
 * 9.求回文数
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
    public static boolean isPalindrome(int x) {
        //负数和末尾为 0 就可以直接返回 false，0是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        //在求回文数后，x还会再/10，所以这时候x可能等于revertedNumber / 10
        //当位数为偶数时，x等于revertedNumber
        return x == revertedNumber || x == revertedNumber / 10;
    }

}
