package structure.trie;

/**
 * 1个根节点指向多个单词，链接数组（指向下一个字母），结尾标记（最后一个节点为true）
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
        //临时节点
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            //如果当前节点不存在该字母，将该字母存入树中
            if (!node.containsKey(curLetter)) {
                node.put(curLetter, new TrieNode());
            }
            //指针到当前节点
            node = node.get(curLetter);
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

    //查找最长前缀，为14题的LongestCommonPrefix服务
    public String searchLongestPrefix(String word) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            //如果节点包含当前字母，且节点只有一个后继节点，且节点没有终点标记
            //如果有2个后继节点，后面的就不是公共前缀了
            //如果有终点标记，说明有一个字符串已经到底了，最长前缀已经找到
            if (node.containsKey(curLetter) && (node.getLinks() == 1) && (!node.isEnd())) {
                //当前字母加入字符串缓冲区
                prefix.append(curLetter);
                //移动到下一节点
                node = node.get(curLetter);
            } else {
                return prefix.toString();
            }

        }
        return prefix.toString();
    }

    private class TrieNode {
        //按顺序存储26个字母，a为第一个
        private TrieNode[] links = new TrieNode[26];
        //标记最后一个节点
        private boolean isEnd;
        // 非空子节点的数量
        private int size;

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

        void setEnd() {
            isEnd = true;
        }

        boolean isEnd() {
            return isEnd;
        }

        int getLinks() {
            return size;
        }
    }
}