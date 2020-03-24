package algorithm.math;

/**
 * 405. 数字转换为十六进制数
 */
public class ToHex {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            //取后4位
            sb.append(map[num & 0b1111]);
            //无符号右移4位,每4位数转为16进制的1位
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}
