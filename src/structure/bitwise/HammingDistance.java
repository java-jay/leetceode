package structure.bitwise;

/**
 * 461. 汉明距离
 *
 * @Auther java_jay
 * @Date 2020/1/13
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int cnt = 0;
        while (z != 0) {
            if ((z & 1) == 1) {
                cnt++;
            }
            z >>= 1;
        }
        return cnt;
    }
}
