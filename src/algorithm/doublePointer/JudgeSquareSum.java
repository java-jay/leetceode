package algorithm.doublePointer;

/**
 * 633. 平方数之和
 */
public class JudgeSquareSum {
    /**
     * 双指针法
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int target = i * i + j * j;
            if (target == c) return true;
            else if (target < c) i++;
            else j--;
        }
        return false;
    }

    /**
     * 费马平方和定理：
     * c的所有形如 4k+3的质因子的幂次均为偶数，或者c除4不等于3
     */
    public static boolean judgeSquareSum2(int c) {
        for (int i = 2; i <= Math.sqrt(c); i++) {
            int count = 0; //记录幂次

            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }

                /** 费马平方和定理 */
                if (i % 4 == 3 && count % 2 != 0) {
                    return false;
                }
            }
        }
       return c % 4 != 3;
    }
}

