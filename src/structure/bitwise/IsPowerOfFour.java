package structure.bitwise;

/**
 * 342. 4的幂
 *
 * @Auther java_jay
 * @Date 2020/2/4
 */
public class IsPowerOfFour {
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && (num % 3 == 1);
    }

    /**
     * x=4的a次方，a=log(4)x=1/2*log(2)x，a必然为整数，所以2*a必然为偶数
     *
     * @param num
     * @return
     */
    public boolean isPowerOfFour2(int num) {
        return (num > 0) && ((Math.log(num) / Math.log(2)) % 2 == 0);
    }

    /**
     * 2的偶次幂为4的幂次方，(4的幂次方)&(4的幂次方*2)=0
     * 即(101010...10)2​ 用十六进制表示为 (aaaaaaaa)16
     *
     * @param num
     * @return
     */
    public boolean isPowerOfFour3(int num) {
        boolean z = (num&1)==0;
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
    }
}
