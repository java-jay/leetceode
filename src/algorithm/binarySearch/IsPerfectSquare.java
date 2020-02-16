package algorithm.binarySearch;

/**
 * 367. 有效的完全平方数
 */
public class IsPerfectSquare {
    public static void main(String[] args) {
        new IsPerfectSquare().isPerfectSquare(808201);
    }

    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long left = 2, right = num / 2;
        while (left <= right) {
            long mid = (left + right) >>> 1;
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
