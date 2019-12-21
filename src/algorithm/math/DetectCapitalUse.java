package algorithm.math;

/**
 * 520. 检测大写字母
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 1.全部字母都是大写，比如"USA"。
 * 2.单词中所有字母都不是大写，比如"leetcode"。
 * 3.如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 */
public class DetectCapitalUse {

    /**
     * 遍历一遍字符串，分别记录大于‘a’和小于‘a’的数量
     * 若全大于a说明是全小写，反之全大写
     * 若只有一个小于a，载判断是否为第一个字符
     *
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        int c1 = 0, c2 = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a') {
                c1++;//小写
            } else {
                c2++;//大写
            }
        }
        if (c1 == word.length() || c2 == word.length()) {//条件1和2
            return true;
        }
        return c2 == 1 && word.charAt(0) < 'a';//条件3
    }
}
