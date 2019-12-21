package algorithm.math;

/**
 * 171. Excel表列序号
 * 就是26进制
 */
public class TitleToNumber {
    public int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            sum = sum * 26 + num;
        }
        return sum;
    }
}
