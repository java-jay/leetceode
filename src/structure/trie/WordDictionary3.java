package structure.trie;

/**
 * 47ms字典树加dfs 超100%
 */
public class WordDictionary3 {
    private Trie trie;

    public static void main(String[] args) {
        WordDictionary3 wordDictionary3 = new WordDictionary3();
        wordDictionary3.addWord("a");
        wordDictionary3.search("a.");
    }

    private class Trie {

        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode node = root;
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char curLetter = word.charAt(i);
                if (!node.containsKey(curLetter)) {
                    node.put(curLetter, new TrieNode());
                }
                node = node.get(curLetter);
            }
            node.isEnd = true;
        }

        //深度查找
        boolean dfs(TrieNode root, String word, int index) {
            //如果索引大于等于待查找单词最大长度，则返回当前节点是否为最后一个节点,这边就是递归的终点
            if (index >= word.length()) {
                return root.isEnd;
            }
            //当前字符
            char curLetter = word.charAt(index);
            //如果当前字符不是.
            if (curLetter != '.') {
                //如果当前节点的数组包含当前字符
                if (root.containsKey(curLetter)) {
                    //遍历到单词的下一个字符
                    return dfs(root.get(curLetter), word, index + 1);
                }
                //如果当前节点的数组不包含当前字符
                return false;
            }
            //如果当前字符是.，就遍历节点数组，如果数组中还有值，就代表.能匹配值
            for (TrieNode link : root.links) {
                //如果当前节点不为空，且单词的下一字符返回true
                if (null != link && dfs(link, word, index + 1)) {
                    return true;
                }
            }
            return false;
        }

        boolean search(String word) {
            return dfs(root, word, 0);
        }
    }

    private class TrieNode {

        TrieNode[] links;

        final int R = 26;

        boolean isEnd;

        TrieNode() {
            links = new TrieNode[R];
        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }
    }

    public WordDictionary3() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }
}
