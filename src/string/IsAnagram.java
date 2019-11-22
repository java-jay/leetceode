package string;

import java.util.*;

/**
 * 242. 有效的字母异位词：字母相同，但次序不同的两个单词
 */
public class IsAnagram {
    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        isAnagram.isAnagram("ant", "tna");
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        Set set=new HashSet();

        list.remove(1);
        System.out.println(list);
    }

    public boolean isAnagram(String s, String t) {
        //字符串长度不同，直接false
        if (s.length() != t.length())
            return false;
        int[] alpha = new int[26];
        //如果字母都相同，循环结束后，数组的值均为0
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }
        //如果数组内有值不为0，则返回false
        for (int i = 0; i < 26; i++)
            if (alpha[i] != 0)
                return false;
        return true;
    }


}
