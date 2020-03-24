package algorithm.math;

/**
 * @Auther java_jay
 * @Date 2019/12/28
 */
public class IsPowerOfThree {
    public static void main(String[] args) {
        System.out.println((int)Math.log(Math.pow(2,31)-1)/Math.log(3));
    }
    //int的最大值是2的31次方-1，可以直接求出int中3的最大幂次方
    public boolean isPowerOfThree(int n) {
        int power=(int)(Math.log(Math.pow(2,31)-1)/Math.log(3));
        return n > 0 && Math.pow(3,power) % n == 0;
    }

    public boolean isPowerOfThree2(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

}
