package algorithm.doublePointer;

/**
 * 415. 字符串相加
 * 双指针法，两个指针各指向字符串末端，然后往前遍历
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int ca = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? num1.charAt(i) - '0' : 0;
            sum += j >= 0 ? num2.charAt(j) - '0' : 0;
            sb.append(sum % 10);
            ca = sum / 10;
        }
        if (ca == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
