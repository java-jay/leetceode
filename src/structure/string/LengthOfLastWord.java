package structure.string;

/**
 * 58. 最后一个单词的长度
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        lengthOfLastWord.lengthOfLastWord("hello");
    }

    public int lengthOfLastWord(String s) {
        //单词的末指针
        int end = s.length() - 1;
        //从后往前遍历，移动到单词的最后一个字母
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        //单词的头指针
        int start = end;
        //移动到单词的前一个空格
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }

    public int lengthOfLastWord2(String s) {
        String[] split = s.split("\\s");
        if (split.length == 0) {
            return 0;
        }
        return split[split.length - 1].length();
    }
}
