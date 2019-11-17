# leetceode

> 用简单的语言解释力扣，学习力扣的过程中学习数据结构与算法。
>
> 博主是一名学习java的跨专业者，在学习过程中不免有一些错误，劳烦各位指出错误。

在线阅读：https://java-jay.github.io/leetceode/#/

## 211. 添加与搜索单词 - 数据结构设计

### 哈希表解法（trie.WordDictionary）

#### 思路

通过建立1个Map集合，key为单词的长度，value为set集合（存放单词）

根据单词长度来存储单词

1---a

2---as，if

3---app，bad

查找时则通过单词长度，找到相应的集合，遍历集合，对每个字符进行比对

#### 代码

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
            for (int i = 0; i < cs.length; i++) {//逐个字符比对
                if (chars[i] != '.' && chars[i] != cs[i]) {//如果单词中不包含. 且两个单词当前字符不匹配
                    continue P;//说明该单词不符合要求，跳到set的下一单词
                }//如果字符是.或字符匹配，就会正常进行下一个i循环
            }
            //循环结束，说明set的当前单词就是要找的单词
            return true;
        }
        return false;
    }
### 前缀树+dfs解法(trie.WordDictionary3)

#### 思路

建立前缀树

添加单词方法和前缀树的添加一样

深度查找：

从0索引开始，获取单词的当前字符

如果当前字符不是. ，就判断树中是否能匹配到字符，然后递归到下一索引

如果当前字符是. ，说明只要数组有值就可以匹配，就遍历节点数组，判断数组是否有值，然后递归到下一索引

当索引等于单词长度时，判断当前节点是否为单词结尾，如果是，返回true

#### 代码

    private Trie trie;
    
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
    
    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        trie.insert(word);
    }
    
    public boolean search(String word) {
        return trie.search(word);
    }
    public WordDictionary() {
    	trie = new Trie();
    }
    
    public void addWord(String word) {
    	trie.insert(word);
    }
    
    public boolean search(String word) {
    	return trie.search(word);
    }
## 说明

### 开源文档生成

利用 docsify 生成文档部署在 Github pages: [docsify 官网介绍](https://docsify.js.org/#/)。

[使用教程](https://www.jianshu.com/p/88e70f32b049)