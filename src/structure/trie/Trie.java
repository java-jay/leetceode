package structure.trie;

/**
 * 208. 实现 Trie (前缀树)，1个根节点指向多个单词，链接数组（指向下一个字母），结尾标记（最后一个节点为true）
 */
public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("leet");
    }

    //根节点
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    //添加一个单词到树中
    public void insert(String word) {
        TrieNode node = root;//临时节点
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            //如果当前节点不存在该字母，将该字母存入树中
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);//指针到当前节点
        }
        node.setEnd();//对最后一个节点设置结尾
    }

    //查找单词
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        //如果找到了节点，且该节点是终点节点，说明找到了单词
        return node != null && node.isEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            //如果当前字符在树中，指针就指向下一节点
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    //查找前缀
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    //查找最长前缀
    public String searchLongestPrefix(String word) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            //如果节点不包含当前字母，且节点只有一个后继节点，且节点不是最后一个节点
            if (node.containsKey(curLetter) && (node.getLinks() == 1) && (!node.isEnd())) {
                //当前字母加入字符串缓冲区
                prefix.append(curLetter);
                //移动到下一节点
                node = node.get(curLetter);
            } else
                return prefix.toString();

        }
        return prefix.toString();
    }
}

class TrieNode {

    // R links to node children
    private TrieNode[] links;//按顺序存储26个字母，a为第一个

    private final int R = 26;

    private boolean isEnd;

    // 非空子节点的数量
    private int size;

    public TrieNode() {
        links = new TrieNode[R];
    }

    //存入的为小写字母，ch - 'a'：获取ch的索引
    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
        size++;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public int getLinks() {
        return size;
    }
}
