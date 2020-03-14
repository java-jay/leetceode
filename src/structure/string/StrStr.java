package structure.string;

/**
 * 28. 实现 strStr()
 */
public class StrStr {
    public static void main(String[] args) {
//        System.out.println(new StrStr().strStr("mississippi", "issip"));
        System.out.println(new StrStr().strStr2("hlllo", "ll"));
    }

    /**
     * 暴力法
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        if (needle.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < l1 - l2 + 1; i++) {
            int j;
            for (j = 0; j < l2; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == l2) {
                return i;
            }
        }
        return -1;
    }

    /**
     * sunday解法
     */
    public int strStr2(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        int i = 0;
        int j = 0;
        // 成功匹配完终止条件：所有needle均成功匹配
        while (j < needle.length()) {
            // 针对haystack匹配完，但needle未匹配完情况处理 如 apple plea
            if (i > haystack.length() - 1) {
                return -1;
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                // 匹配则index均加1
                i++;
                j++;
            } else {
                //如果子串的首字母不匹配，可以直接跳跃一个子串长度查找
                int nextCharIndex = i - j + needle.length();
                if (nextCharIndex < haystack.length()) {
                    // 获取该字符在needle最后一次出现的索引
                    int loc = needle.lastIndexOf(haystack.charAt(nextCharIndex));
                    if (loc == -1) {
                        // 该字符不存在于needle中则设置i为该字符的下一个字符
                        i = nextCharIndex + 1;
                    } else {
                        // 该字符存在于needle中，i要倒退
                        i = nextCharIndex - loc;
                    }
                    j = 0;
                } else {
                    return -1;
                }
            }
        }
        return i - j;
    }

    /**
     * kmp不一定更快，而且更难理解
     * kmp搜索，详见https://leetcode-cn.com/problems/implement-strstr/solution/kmp-suan-fa-xiang-jie-by-labuladong/
     * 用 pat 表示模式串，长度为 M，txt 表示文本串，长度为 N。KMP 算法是在 txt 中查找子串 pat
     * 因为 KMP 算法知道字符 b 之前的字符 a 都是匹配的，所以每次只需要比较字符 b 是否被匹配就行了。
     * KMP 算法永不回退 txt 的指针 i，不走回头路（不会重复扫描 txt），
     * 而是借助 dp 数组中储存的信息把 pat 移到正确的位置继续匹配
     * <p>
     * dp[j][c] = next
     * 0 <= j < M，代表当前的状态
     * 0 <= c < 256，代表遇到的字符（ASCII 码）
     * 0 <= next <= M，代表下一个状态
     * <p>
     * dp[4]['A'] = 3 表示：
     * 当前是状态 4，如果遇到字符 A，
     * pat 应该转移到状态 3
     * <p>
     * dp[1]['B'] = 2 表示：
     * 当前是状态 1，如果遇到字符 B，
     * pat 应该转移到状态 2
     * <p>
     * 如果遇到的字符 c 和 pat[j] 匹配的话，状态就应该向前推进一个，也就是说 next = j + 1
     * 如果字符 c 和 pat[j] 不匹配的话，状态就要回退
     * 找到和当前状态具有相同的前缀的位置（影子状态X），再看看是前进还是继续后退(动态规划思想)
     */
    static class KMP {
        private int[][] dp;
        private String pat;

        public KMP(String pat) {
            this.pat = pat;
            //子串长度
            int M = pat.length();
            // dp[状态][字符] = 下个状态
            dp = new int[M][256];
            // 初始状态到状态1，如果第一个字符就不匹配，初始状态也不动
            dp[0][pat.charAt(0)] = 1;
            // 影子状态 X 初始为 0
            int X = 0;
            // 当前状态 j 从 1 开始，遍历子串
            for (int j = 1; j < M; j++) {
                //遍历ASCII码
                for (int c = 0; c < 256; c++) {
                    if (pat.charAt(j) == c)
                        dp[j][c] = j + 1;
                    else//如果匹配不到当前字符，就回退
                        dp[j][c] = dp[X][c];
                }
                // 更新影子状态，总是与j保持相同前缀
                X = dp[X][pat.charAt(j)];
            }
        }

        public int search(String txt) {
            int M = pat.length();
            int N = txt.length();
            // pat 的初始态为 0
            int j = 0;
            //遍历长串
            for (int i = 0; i < N; i++) {
                // 当前是状态 j，遇到字符 txt[i]，
                // pat 应该转移到哪个状态？
                j = dp[j][txt.charAt(i)];
                // 如果达到终止态，返回匹配开头的索引
                if (j == M) return i - M + 1;
            }
            // 没到达终止态，匹配失败
            return -1;
        }
    }

}
