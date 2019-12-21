package structure.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. 宝石与石头
 */
public class numJewelsInStones {
    /**
     * hashSet
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        int sum = 0;
        for (int i = 0; i < S.length(); i++) {

            if (set.contains(S.charAt(i))) sum++;
        }
        return sum;
    }
}
