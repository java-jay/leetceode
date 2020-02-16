package structure.bitwise;

/**
 * 693. 交替位二进制数
 * 如果符合的话，异或后结果为1111...
 * @Auther java_jay
 * @Date 2020/2/4
 */
public class HasAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int m = n ^ (n >>> 1);
        return (m & (m + 1)) == 0;
    }
}
