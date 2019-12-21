package structure.string;

/**
 * 389. 找不同
 */
public class FindTheDifference {
    /**
     * 与IsAnagram一样的方法
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        arr[t.charAt(t.length()-1) - 'a']--;
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) return (char) ('a' + i);
        }
        return ' ';
    }

    /**
     * 异或运算（不带进位的加法）
     * 一个数和0做XOR运算等于本身：a⊕0 = a
     * 一个数和其本身做XOR运算等于 0：a⊕a = 0
     * XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
     */
    public char findTheDifference2(String s, String t) {
        //获取t的最后一个字符，用这个字符与其他字符做异或运算，最后剩下的值就是多出来的值（结合律）
        char ans = t.charAt(t.length()-1);
        for(int i = 0; i < s.length(); i++) {
            ans ^= s.charAt(i);
            ans ^= t.charAt(i);
        }
        return ans;
    }
}
