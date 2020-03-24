package algorithm.math;

/**
 * 168. Excel表列名称,26进制
 */
public class ConvertToTitle {
    public String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            n--;//这里稍作处理，因为它是从1开始
            stringBuilder.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        return stringBuilder.reverse().toString();
    }
}