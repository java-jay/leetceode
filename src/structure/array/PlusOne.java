package structure.array;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 66.加一
 * 末位无进位，则末位加一即可，因为末位无进位，前面也不可能产生进位，比如45 => 46
 * 末位有进位，在中间位置进位停止，则需要找到进位的典型标志，即为当前位%10后为0，则前一位加1，直到不为0为止，比如499 => 500
 * 末位有进位，并且一直进位到最前方导致结果多出一位，对于这种情况，需要在第2种情况遍历结束的基础上，进行单独处理，比如999 => 1000
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            //如果是正常相加就直接返回，如果有进位就会进行下一次循环
            if (digits[i] != 0) {
                return digits;
            }
        }
        //循环结束仍未返回，说明是999类型，需要定义新数组，新数组恰好都为0，只需要对开头赋值
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
