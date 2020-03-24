package algorithm.math;

/**
 * 快速幂取模
 * 当b==11时,11的二进制是1011,转换为 a2^0*a2^1*a2^3，也就是a^1*a^2*a^8
 *
 * @Auther java_jay
 * @Date 2020/3/24
 */
public class FastPower {
    public static void main(String[] args) {
        new FastPower().fastPower(2, 11, 10);
    }

    int fastPower(int a, int b, int c) {
        int ans = 1;
        int base = a % c;
        while (b > 0) {
            if ((b ^ 1) != 0) {
                //第一次进入为2的1次方
                ans = (ans * base) % c;
            }
            //第一次为2的2次方
            base = (base * base) % c;
            b >>= 1;
        }
        return ans;
    }
}
