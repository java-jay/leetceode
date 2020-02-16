package structure.bitwise;

/**
 * 231. 2的幂
 * 1000&0111=0（8&7=0）
 * @Auther java_jay
 * @Date 2020/1/15
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
