package algorithm.math;

/**
 * 507. 完美数
 * 28 = 1 + 2 + 4 + 7 + 14
 */
public class CheckPerfectNumber {
    public static void main(String[] args) {
        CheckPerfectNumber checkPerfectNumber = new CheckPerfectNumber();
        checkPerfectNumber.checkPerfectNumber2(28);
    }

    //一个数的因子中位数是他的平方根，遍历2到平方根，把整除值和对应的成对值都加上
    //如果平方根是整数，最后再加上平方根
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int sum = 1;
        int i;
        for (i=2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {//如果能被整除，就加上这个值和他的成对值
                sum += i;
                sum += num / i;
            }
        }
        if (i * i == num) {
            sum += i;
        }
        return sum == num;
    }

    /**
     * 欧几里得-欧拉定理
     * 每个偶完全数都可以写成 2的p-1次方*（2的p次方-1）,p为素数
     */
    public int pn(int p) {
        return (1 << (p - 1)) * ((1 << p) - 1);//这个返回值就是int
    }

    public boolean checkPerfectNumber2(int num) {
        int[] primes = new int[]{2, 3, 5, 7, 13, 17, 19, 31};
        for (int prime : primes) {
            if (pn(prime) == num)
                return true;
        }
        return false;
    }

}
