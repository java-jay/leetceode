package algorithm.math;

/**
 * 169. 多数元素
 * Boyer-Moore 投票算法
 * 把众数当做1，把其他数当做-1,所有的数加起来，一定大于1
 * 维护一个计数器，把第一个数当做众数候选，往后遍历，当计数器变为0时，舍弃前面的数，把下一个数当做众数候选
 * 最后剩下的众数候选就是所要的数
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        //计数器和众数候选
        int count=0,candidate=0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

}
