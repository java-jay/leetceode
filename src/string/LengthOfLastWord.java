package string;

/**
 * 58. 最后一个单词的长度
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        lengthOfLastWord.lengthOfLastWord("hello world");
    }

    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        //从后往前遍历，如果末尾是空格且end大于等于0，就往前一位
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return -1;
        int start = end;
        //寻找单词前的空格，如果当前不是空格，就往前一位
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}
