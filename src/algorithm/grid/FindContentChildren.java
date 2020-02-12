package algorithm.grid;

import java.util.Arrays;

/**
 * 455. 分发饼干
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        //从胃口最小的开始找，先进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, count = 0;
        while (i < g.length && j < s.length) {
            //如果最小的尺寸满足最小的胃口
            if (s[j] >= g[i]) {
                count++;
                //胃口指针右移
                i++;
            }
            //尺寸指针右移
            j++;
        }
        return count;
    }
}
