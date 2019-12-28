package algorithm.math;

/**
 * @Auther java_jay
 * @Date 2019/12/28
 */
public class IsPowerOfThree {
    //int的最大值是2的31次方-1，可以直接求出int中3的最大幂次方
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
