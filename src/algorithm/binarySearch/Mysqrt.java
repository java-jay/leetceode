package algorithm.binarySearch;

/**
 * 69. x 的平方根
 */
public class Mysqrt {
    public static void main(String[] args) {
        System.out.println(new Mysqrt().mySqrt(8));
    }

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 1, right = x;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int sqrt = x / mid;
            if (mid == sqrt) {
                return mid;
            } else if (mid < sqrt) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    //牛顿法
    public int mySqrt2(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }
}
