package structure.string;

/**
 * 205. 同构字符串
 *
 * @Auther java_jay
 * @Date 2020/1/10
 */
public class IsIsomorphic {
    public static void main(String[] args) {
        new IsIsomorphic().isIsomorphic("egg","add");
    }
    public boolean isIsomorphic(String s, String t) {
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (preIndexOfS[sc] != preIndexOfT[tc]) {
                return false;
            }
            //如果出现了一个元素映射多个元素，两个元素值就不一样了
            preIndexOfS[sc] = i + 1;
            preIndexOfT[tc] = i + 1;
        }
        return true;
    }
}
