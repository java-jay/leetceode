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
        int gIndex=0, sIndex=0, count=0;
        while (gIndex < g.length && sIndex < s.length) {
            if (s[sIndex] >= g[gIndex]) {//如果最小的尺寸满足最小的胃口
                count++;
                gIndex++;//胃口指针右移
            }
            sIndex++;//尺寸指针右移
        }
        return count;
    }
}
