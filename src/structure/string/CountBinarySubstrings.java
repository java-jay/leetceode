package structure.string;

/**
 * 696. 计数二进制子串
 *
 * @Auther java_jay
 * @Date 2020/1/10
 */
public class CountBinarySubstrings {
    public static void main(String[] args) {
        new CountBinarySubstrings().countBinarySubstrings("00110011");
    }
    public int countBinarySubstrings(String s) {
        //当前连续字符数,前一个连续字符数
        int preLen = 0, curLen = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            //与前一个字符相等，所以当前连续字符数+1
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {//与前一个字符不相等，赋值给前一个连续字符数，当前连续字符数变为1
                preLen = curLen;
                curLen = 1;
            }
            //如果前一个连续字符数大于当前连续字符数，例如001,其中的01符合条件
            //如果前一个连续字符数等于当前连续字符数，例如0011,符合条件
            if (preLen >= curLen) {
                count++;
            }
        }
        return count;
    }
}
