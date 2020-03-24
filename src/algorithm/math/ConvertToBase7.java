package algorithm.math;

/**
 * 504. 七进制数
 */
public class ConvertToBase7 {
    public String convertToBase7(int num) {
        String ans = "";
        if (num < 0) {
            num = 0 - num;
            ans += "-";
        }
        StringBuilder sb = new StringBuilder();
        //如果num是0，也应该进行一次字符串拼接，所以用do while
        do {
            sb.append(String.valueOf(num % 7));
            num /= 7;
        } while (num > 0);
        return ans + sb.reverse().toString();
    }
}
