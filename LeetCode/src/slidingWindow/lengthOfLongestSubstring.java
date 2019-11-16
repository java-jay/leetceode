package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s="pwwkew";
        int i = lengthOfLongestSubstring3(s);
        System.out.println(i);
    }

    /**
     * 暴力算法，时间复杂度：O(n3)
     * i和j两轮遍历，如果取到的子串中有重复值则不继续计算长度
     * 将每一种子串可能性都考虑到
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    /**
     * 滑动窗口
     * j从左到右遍历，把遍历到的数字放到set中，如果set中已有，就让i从左到右遍历，把遍历到的数字从set中去除
     * 直到j要遍历的数字可以放入set中
     * 当j遍历结束后结束循环，j-i就是最大子串长度
     * 时间复杂度：O(2n)=O(n)，在最糟糕的情况下，每个字符将被 i 和 j 访问两次。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 滑动窗口优化
     * j进行一轮遍历
     * 用hashmap进行存储，键为字符，值为j+1，也就是从1开始
     * 当遇到重复值时，i赋值为当前重复值的索引
     * 最后返回j-i+1
     * 可以想象成j在拉窗口，每次拉成功后就计算长度，
     * 遇到相同值就是遇到墙，j先到墙，发现不能拉，i就到墙对应的值（下一个没有墙的地方），重新开始拉窗口
     * 每个键对应的值的意思是，索引为n的字符不是它
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /**
     * 假设字符集为 ASCII 128
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring4(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }



}
