package algorithm.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * 输入一个整数n 1<n<10^9
 * 输出一个整数
 * 从整数中任意取k个数，并选取一个数为队长，然后对10^9+7取模
 * 例如输入2，有{1.}，{2.}，{1.，2}，{1，2.}，.代表队长，输出4
 * @Auther java_jay
 * @Date 2020/3/23
 */
public class Captain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String n = sc.next();
            BigInteger in = BigInteger.valueOf(Long.parseLong(n));
            BigInteger num = f(in);
            BigInteger x = BigInteger.valueOf(10).pow(9).add(BigInteger.valueOf(7));
            System.out.println(num.mod(x));
        }
    }

    private static BigInteger f(BigInteger n) {
        return n.multiply(BigInteger.valueOf(2).pow(n.intValue() - 1));
    }
}
