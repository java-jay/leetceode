package algorithm.math;

/**
 * 172. 阶乘后的零
 * 只要有几个因数为10，就有几个0
 * 10=5*2，所以只要有几个因数为5，就有几个0
 * 每隔5个数，就有1个5，每隔25个数，就有2个5，即n / 5 + n / 25 + n / 125 ...
 */
public class TrailingZeroes {
    public static void main(String[] args) {
        System.out.println(new TrailingZeroes().trailingZeroes(25));
    }
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
