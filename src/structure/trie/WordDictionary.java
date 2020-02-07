package structure.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 211. 添加与搜索单词 - 数据结构设计，支持正则表达式
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * <p>
 * 哈希表实现
 * 执行用时 : 51 ms, 击败了98.29% 的用户 内存消耗 : 54.5 MB, 击败了95.16% 的用户
 */
public class WordDictionary {

    Map<Integer, Set<String>> map;

    public WordDictionary() {
        map = new HashMap<>();
    }

    //添加单词
    public void addWord(String word) {
        int length = word.length();
        if (map.get(length) != null) {
            //如果map中已经有该单词长度的单词，就让set再加一个单词
            map.get(length).add(word);
        } else {
            //如果该长度是新出现的，就创建一个新set集合接收
            Set<String> set = new HashSet<>();
            set.add(word);
            map.put(length, set);
        }
    }

    //查找单词
    public boolean search(String word) {
        //找到该单词长度的set集合
        Set<String> set = map.get(word.length());
        //不存在该长度的字符串，直接返回false；
        if (set == null) {
            return false;
        }
        //如果set存在该单词，直接返回true
        if (set.contains(word)) {
            return true;
        }
        //如果不存在，则判断正则表达式
        //带标签的continue，可以指示continue跳出的是哪一个循环
        P:
        //遍历set集合
        for (String s : set) {
            //逐个字符对比
            for (int i = 0; i < s.length(); i++) {
                //如果单词中不包含.且两个单词当前字符不匹配
                if (word.charAt(i) != s.charAt(i) && word.charAt(i) != '.') {
                    //跳出到set的下一单词
                    continue P;
                }
            }
            //循环结束，说明set的当前单词就是要找的单词
            return true;
        }
        return false;
    }
}
