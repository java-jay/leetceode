package structure.bitwise;

/**
 * 371. 两整数之和
 * @Auther java_jay
 * @Date 2020/2/4
 */
public class GetSum {
    /**
     * a ^ b 表示没有考虑进位的情况下两数的和，(a & b) << 1 就是进位
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum((a ^ b), (a & b) << 1);
    }
}
