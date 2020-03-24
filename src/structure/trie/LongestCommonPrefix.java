package structure.trie;

/**
 * 14. 最长公共前缀
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 1、所求的最长公共前缀子串一定是每个字符串的前缀子串。所以随便选择一个字符串作为标准，把它的前缀串，与其他所有字符串进行判断，看是否是它们所有人的前缀子串。这里的时间性能是O(m*n*m)。
 * <p>
 * 2、列出所有的字符串的前缀子串，将它们合并后排序，找出其中个数为n且最长的子串。时间性能为O(n*m+m*n*log(m*n))
 * <p>
 * 3、纵向扫描：从下标0开始，判断每一个字符串的下标0，判断是否全部相同。直到遇到不全部相同的下标。时间性能为O(n*m)。
 * <p>
 * 4、横向扫描：前两个字符串找公共子串，将其结果和第三个字符串找公共子串……直到最后一个串。时间性能为O(n*m)。
 * <p>
 * 5、借助trie字典树。将这些字符串存储到trie树中。那么trie树的第一个分叉口之前的单分支树的就是所求。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"leetcode","le","lee"};
//        String s = longestCommonPrefix4(strs);
//        System.out.println(s);
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String s = longestCommonPrefix.longestCommonPrefix2(strs);
        System.out.println(s);
    }

    /**
     * 水平查找
     * 先假设数组第一个值就是最长前缀
     * 然后从末尾一个字母一个字母地缩减，直到找到前缀（strs[i].indexOf(prefix) != 0）
     * <p>
     * 时间复杂度：O(S)，S 是所有字符串中字符数量的总和。
     * <p>
     * 最坏的情况下，n 个字符串都是相同的。算法会将 S1与其他字符串 [S2…Sn]都做一次比较。
     * 这样就会进行 S 次字符比较，其中 S 是输入数据中所有字符数量。
     * <p>
     * 空间复杂度：O(1)，我们只需要使用常数级别的额外空间。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //如果假定前缀串不是后面的字符串的前缀
            while (strs[i].indexOf(prefix) != 0) {
                //前缀串每次末尾剔除1
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * 水平扫描，效率最好
     * <p>
     * 时间复杂度：O(S)，S 是所有字符串中字符数量的总和。
     * <p>
     * 最坏情况下，输入数据为 n个长度为 m的相同字符串，算法会进行 S=m∗n次比较。
     * 可以看到最坏情况下，本算法的效率与算法一相同，但是最好的情况下，算法只需要进行 n∗minLen次比较，
     * 其中 minLen是数组中最短字符串的长度。
     * <p>
     * 空间复杂度：O(1)，我们只需要使用常数级别的额外空间。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            //从数组的第二个值开始
            for (int j = 1; j < strs.length; j++) {
                //如果该字符的索引=另一个字符串的长度，或者两个字符串的当前索引不同
                //说明后者是前者的前缀
                if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    //返回第一个值的当前长度的字符串
                    return strs[0].substring(0, i);
                }
            }
        }
        //说明所有的字符串都一样
        return strs[0];
    }

    /**
     * 分治算法
     * <p>
     * 最坏情况下，我们有 n 个长度为 m 的相同字符串。
     * <p>
     * 时间复杂度：O(S)，S 是所有字符串中字符数量的总和，S=m∗n
     * <p>
     * 时间复杂度的递推式为 T(n)=2⋅T(n/2)+O(m)， 化简后可知其就是 O(S)。
     * 最好情况下，算法会进行 minLen⋅n次比较，其中 minLen是数组中最短字符串的长度。
     * <p>
     * 空间复杂度：O(m⋅log(n))
     * <p>
     * 内存开支主要是递归过程中使用的栈空间所消耗的。 一共会进行 log(n)次递归，
     * 每次需要 m 的空间存储返回结果，所以空间复杂度为 O(m⋅log(n))。
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    //拆分
    private static String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    //合并
    static String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    /**
     * 二分查找法
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            //最小长度为最小字符串的长度
            minLen = Math.min(minLen, str.length());
        //1和minLen代表第几个数，因为substring方法的右区间是开区间，所以不能用索引
        int low = 1;
        int high = minLen;
        while (low <= high) {
            //取出开头到中位数的长度
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                //如果每个字符串都以该前缀开头，就可以确定左指针指定的是正确的前缀，左指针到中位数后面一位
                low = middle + 1;
            else//如果有字符串不以该前缀开头，右指针到中位数前面一位
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len) {
        //取第一个字符串，取出二分查找确定的长度确定的前缀
        String str1 = strs[0].substring(0, len);
        //从第二个字符串开始，判断每个字符串是否以该前缀开头
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }

    /**
     * 前缀树
     * trie树的第一个分叉口之前的单分支树的就是所求
     * 从数组的第二个值开始加入树，对第一个值进行遍历，判断树中当前节点是否包含该字母，
     * 且只有一个后继节点（表明没有分支，有共同前缀）
     * <p>
     * 时间复杂度：预处理过程 O(S)，其中 S 数组里所有字符串中字符数量的总和，
     * 最长公共前缀查询操作的复杂度为 O(m)。
     * <p>
     * 建立字典树的时间复杂度为 O(S)。在字典树中查找字符串 q 的最长公共前缀在最坏情况下需要 O(m) 的时间。
     * <p>
     * 空间复杂度：O(S)，我们只需要使用额外的 S 空间建立字典树。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix5(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        Trie trie = new Trie();
        //从数组的第二个值开始加入树
        for (int i = 1; i < strs.length; i++) {
            trie.insert(strs[i]);
        }
        return trie.searchLongestPrefix(strs[0]);
    }
}
