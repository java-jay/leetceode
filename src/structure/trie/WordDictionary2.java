package structure.trie;

/**
 * 这个写的比较杂，WordDictionary3更好理解，WordDictionary1则是用哈希表解决
 * java 前缀树 执行结果： 通过 显示详情 执行用时 : 67 ms ,
 * 在所有 java 提交中击败了 98.27% 的用户 内存消耗 : 58.7 MB ,
 * 在所有 java 提交中击败了 93.01% 的用户
 * 通过result和count能计算出正则表达式匹配到了几个单词
 */
class TrieNode2 {
    private int count;

    TrieNode2[] nextNode = new TrieNode2[26];

    public TrieNode2() {
        count = 0;

    }

    public void insert(TrieNode2 root, String word) {
        if (root == null || word == null || word.length() == 0) {
            return;
        }
        for (char c : word.toCharArray()) {
            if (root.nextNode[c - 'a'] == null) {
                root.nextNode[c - 'a'] = new TrieNode2();
            }
            root = root.nextNode[c - 'a'];//移动到下一节点

        }
        root.count++;//最后一个节点为1，标记此为最后一个节点
    }

    public int search(TrieNode2 root, String word) {
        if (root == null || word == null || word.length() == 0) {
            return -1;
        }
        char[] charArray = word.toCharArray();
        for (int j = 0; j < charArray.length; j++) {//遍历单词字符数组
            //如果该字符不是正则表达式，且当前节点的下一节点为空，则返回false
            if (charArray[j] != '.' && root.nextNode[charArray[j] - 'a'] == null) {
                return -1;
            } else if (charArray[j] == '.') {//如果该字符是正则表达式
                int result = 0;
                //由于不知道下一个节点对应数组的哪个索引，所以要从头查找
                for (int i = 0; i < 26; i++) {
                    //如果遍历到最后一个字符
                    if (j == charArray.length - 1) {
                        //如果在该索引，当前节点有下一节点，且下一节点是最后一个节点
                        if (root.nextNode[i] != null && root.nextNode[i].count != 0) {
                            result += root.nextNode[i].count;//返回结果数
                        }
                    } else {//如果遍历到的不是最后一个字符
                        //将该索引下，下一节点和当前字符后的单词递归
                        int r = search(root.nextNode[i], word.substring(j + 1));
                        if (r > 0) {
                            result += r;
                        }
                    }
                }
                if (result > 0) {
                    return result;
                }
                return -1;
            }
            //移动到下一节点
            root = root.nextNode[charArray[j] - 'a'];
        }
        if (root.count == 0) {
            return -1;
        }
        return root.count;
    }


}

class WordDictionary2 {
    public static void main(String[] args) {
        WordDictionary2 wordDictionary2=new WordDictionary2();
        wordDictionary2.addWord("asp");
        wordDictionary2.addWord("app");
        wordDictionary2.search("a..");
    }
    private TrieNode2 trieNode;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary2() {
        trieNode = new TrieNode2();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        trieNode.insert(trieNode, word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        int search = trieNode.search(trieNode, word);//没有找到就是-1
        System.out.println(search);
        return search!=-1;
    }
}
