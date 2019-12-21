package algorithm.math;

/**
 * 204. 计数质数,返回区间 [2, n) 中有几个素数
 * 时间复杂度： O(N * logN)
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        int count = 0;
        //如果不是素数，则为true，初始化均为false
        boolean[] nums = new boolean[n];
        //如果在 [2,sqrt(n)] 这个区间之内没有发现可整除因子，就可以直接断定 n 是素数了
        for (int i = 2; i * i < n; i++) {
            //因为已知2为素数，所以i=2时肯定会进入if语句
            if (!nums[i]) {
                //素数的倍数肯定不是素数，因为从2*i的数之前已经遍历过，所以可以直接从i*i开始
                for (int j = i * i; j < n; j += i) {
                    if (nums[j])//如果该数已经标记为不是素数（公倍数），则跳到下一循环
                        continue;
                    count++;//非素数个数加1
                    nums[j] = true;//标记为非素数
                }
            }
        }
        return n - count - 2;//因为1不属于素数，n不在范围内，所以要再-2

    }
}
