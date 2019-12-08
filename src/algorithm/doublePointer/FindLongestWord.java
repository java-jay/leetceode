package algorithm.doublePointer;

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
        List<String> list=new ArrayList<>();
        list.add("ale");
        list.add("abpcp");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
        System.out.println(new FindLongestWord().findLongestWord("abpcplea", list));
    }
    //哈希表，与211. 添加与搜索单词类似
    public String findLongestWord(String s, List<String> d) {
        if (s == null || d == null || d.size() == 0) return "";
        int max_len = 0;//最大长度
        Map<Integer, List<String>> map = new HashMap<>();//存储长度和字符串集合，相同长度的字符串存一个集合里
        //遍历集合，存放字符串到map中
        for (String str : d) {
            if (str.length() > max_len) max_len = str.length();//设置最新的最大长度
            if (map.containsKey(str.length())) {
                map.get(str.length()).add(str);//添加该长度字符串
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(str.length(), list);//添加新的字符串集合
            }
        }
        for (int len = max_len; len >= 0; --len) {//从最大长度开始遍历，存储到结果集合中
            List<String> rec = new ArrayList<>();
            if (!map.containsKey(len)) continue;
            for (String str : map.get(len)) {//遍历map当前长度的值
                if (validate(s, str)) rec.add(str);//将给定字符串与当前字符串比较，如果有效，就加入结果集合
            }
            //获得字典顺序最小的字符串
             if (rec.size() > 0) {
                String result = rec.get(0);
                for (int i = 1; i < rec.size(); ++i) {
                    if (rec.get(i).compareTo(result) < 0) result = rec.get(i);//找到结果集合中的最长字符串
                }
                return result;
            }
        }
        return "";
    }

    private boolean validate(String s1, String s2) {
        if (s1.length() < s2.length()) return false;
        char[] c1 = s1.toCharArray();//给定字符串
        char[] c2 = s2.toCharArray();//当前字符串
        int index1, index2;
        //每次循环结束，给定字符串指针右移
        for (index1 = 0, index2 = 0; index1 < c1.length && index2 < c2.length; ++index1) {
            if (c1[index1] == c2[index2]) ++index2;//如果相等，当前字符串指针右移
        }
        //如果指针到达当前字符串末端，说明该字符符合要求
        return index2 == c2.length;
    }

}
