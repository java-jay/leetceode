package structure.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * compareTo方法：
 * 首先取出两个字符串的长度，遍历二者字符串，返回ASCII码相减后的值。
 * 若二者字母相等，但长度不相等，则返回字符串长度的差值
 */
public class FindLongestWord {
    public static void main(String[] args) {
        System.out.println("a".compareTo("ab"));
        List<String> list = new ArrayList<>();
        list.add("ale");
        list.add("abpcp");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
        System.out.println(new FindLongestWord().findLongestWord("abpcplea", list));
    }

    /**
     * 哈希表，与211. 添加与搜索单词类似
     *
     * @param s
     * @param d
     * @return
     */
    public String findLongestWord(String s, List<String> d) {
        if (s == null || d == null || d.size() == 0) {
            return "";
        }
        //最大长度
        int maxLen = 0;
        //存储长度和字符串集合，相同长度的字符串存一个集合里
        Map<Integer, List<String>> map = new HashMap<>();
        //遍历集合，存放字符串到map中
        for (String str : d) {
            //设置最新的最大长度
            if (str.length() > maxLen) {
                maxLen = str.length();
            }
            if (map.containsKey(str.length())) {
                //添加该长度字符串
                map.get(str.length()).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                //添加新的字符串集合
                map.put(str.length(), list);
            }
        }
        //从最大长度开始遍历，存储到结果集合中
        for (int len = maxLen; len >= 0; --len) {
            List<String> rec = new ArrayList<>();
            if (!map.containsKey(len)) {
                continue;
            }
            //遍历map当前长度的值
            for (String str : map.get(len)) {
                //将给定字符串与当前字符串比较，如果有效，就加入结果集合
                if (validate(s, str)) {
                    rec.add(str);
                }
            }
            //获得字典顺序最小的字符串
            if (rec.size() > 0) {
                String result = rec.get(0);
                for (int i = 1; i < rec.size(); ++i) {
                    //找到结果集合中的最长字符串
                    if (rec.get(i).compareTo(result) < 0) {
                        result = rec.get(i);
                    }
                }
                return result;
            }
        }
        return "";
    }

    private boolean validate(String s1, String s2) {
        if (s1.length() < s2.length()) return false;
        //给定字符串
        char[] c1 = s1.toCharArray();
        //当前字符串
        char[] c2 = s2.toCharArray();
        int index1, index2;
        //每次循环结束，给定字符串指针右移
        for (index1 = 0, index2 = 0; index1 < c1.length && index2 < c2.length; ++index1) {
            if (c1[index1] == c2[index2]) {
                //如果相等，当前字符串指针右移
                ++index2;
            }
        }
        //如果指针到达当前字符串末端，说明该字符符合要求
        return index2 == c2.length;
    }

    /**
     * 双指针法
     *
     * @param s
     * @param d
     * @return
     */
    public String findLongestWord2(String s, List<String> d) {
        String longestWord = "";
        //遍历数组，数组内每个元素为子字符串
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            //如果该子字符串长度，小于当前最长子字符串长度，或者二者长度相等，但其字典顺序更大
            //则跳过本次循环
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            //如果子字符串能够匹配上字符串，就将其赋给当前最长子字符串
            if (isSubstr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    private boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                //相等，则子字符串指针前进一位
                j++;
            }
            //无论两个字符相不相等，字符串指针都前进一位
            i++;
        }
        //子字符串指针是否到达结尾，如果到达了，说明能与字符串匹配
        return j == target.length();
    }
}
