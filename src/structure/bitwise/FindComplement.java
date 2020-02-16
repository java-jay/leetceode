package structure.bitwise;

/**
 * 476. 数字的补数
 *
 * @Auther java_jay
 * @Date 2020/2/4
 */
public class FindComplement {
    /**
     * mask |= mask >> 1    11000000
     * mask |= mask >> 2    11110000
     * mask |= mask >> 4    11111111
     * @param num
     * @return
     */
    public int findComplement(int num) {
        int mask = num;
        mask |= mask >> 1;
        mask |= mask >> 2;
        mask |= mask >> 4;
        mask |= mask >> 8;
        //mask的位数为n的位数，但全为1
        mask |= mask >> 16;
        return (mask ^ num);
    }

    public int findComplement2(int num) {
        if (num == 0) {
            return 1;
        }
        int mask = 1 << 30;
        while ((num & mask) == 0) {
            mask >>= 1;//1移动到num的首位
        }
        mask = (mask << 1) - 1;//获取掩码（1111...）
        return num ^ mask;
    }
}
