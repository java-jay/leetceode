package algorithm.math;

/**
 * 458. 可怜的小猪
 * 有 1000 只水桶，其中有且只有一桶装的含有毒药，其余装的都是水。它们从外观看起来都一样。
 * 如果小猪喝了毒药，它会在 15 分钟内死去。
 * 问题来了，如果需要你在一小时内，弄清楚哪只水桶含有毒药，你最少需要多少只猪？
 */
public class PoorPigs {
    /**
     * 一头猪喝每行的混合后的水，一头猪喝每列的混合后的水，根据行和列的时间推断，哪个是死亡的点
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        //一头猪可以喝的水的次数
        int times = minutesToTest / minutesToDie;
        //一头猪可以验证桶的个数
        int base = times + 1;
        // base ^ ans >= buckets
        // ans >= log(buckets) / log(base)
        double temp = Math.log(buckets) / Math.log(base);
        //向上取整
        int ans = (int) Math.ceil(temp);
        return ans;
    }
}
