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
 *
 * 哈希表实现
 * 执行用时 : 51 ms, 击败了98.29% 的用户 内存消耗 : 54.5 MB, 击败了95.16% 的用户
 */
public class WordDictionary {

    Map<Integer, Set<String>> map = new HashMap<>();//key:字符串长度,value:字符串集合（set：确保唯一）

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
        Set<String> set = map.get(word.length());//找到该单词长度的set集合
        if (set == null) {  //不存在该长度的字符串，直接返回false；
            return false;
        }
        if (set.contains(word)) return true;//如果set存在该单词，直接返回true
        //如果不存在，则判断正则表达式
        char[] chars = word.toCharArray();//转换为字符数组
        P://带标签的continue，可以指示continue跳出的是哪一个循环
        for (String s : set) {//遍历set集合
            char[] cs = s.toCharArray();//把遍历到的单词转字符数组
            for (int i = 0; i < cs.length; i++) {//逐个字符对比
                if (chars[i] != '.' && chars[i] != cs[i]) {//如果单词中不包含.且两个单词当前字符不匹配
                    continue P;//跳出到set的下一单词
                }
            }
            //循环结束，说明set的当前单词就是要找的单词
            return true;
        }
        return false;
    }
}
