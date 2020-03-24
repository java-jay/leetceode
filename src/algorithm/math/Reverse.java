package algorithm.math;

/**
 * 7. 整数反转
 * 假设我们的环境只能存储得下 32 位的有符号整数，
 * 则其数值范围为 [−2的31次方,  2的31次方 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Reverse {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int temp = x % 10;
            x /= 10;
            // (2^(31)-1)/10= 2147483647/10，个位为7，2147483640+7=Integer.MAX_VALUE
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }
            // (-2^(31))/10= -2147483648/10，-2147483640-8=Integer.MIN_VALUE
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && temp < -8)) {
                return 0;
            }
            ans = ans * 10 + temp;
        }
        return ans;
    }
}
