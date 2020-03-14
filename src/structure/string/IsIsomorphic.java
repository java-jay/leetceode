package structure.string;

/**
 * 205. 同构字符串
 *
 * @Auther java_jay
 * @Date 2020/1/10
 */
public class IsIsomorphic {
    public static void main(String[] args) {
        new IsIsomorphic().isIsomorphic("egg", "add");
    }

    public boolean isIsomorphic(String s, String t) {
        int[] indexs = new int[256];
        int[] indext = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i), ct = t.charAt(i);
            if (indexs[cs] != indext[ct]) {
                return false;
            }
            indexs[cs] = i + 1;
            indext[ct] = i + 1;
        }
        return true;
    }
}
