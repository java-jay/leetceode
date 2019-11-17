package array;

/**
 * 27. 移除元素
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement removeElement=new RemoveElement();
        removeElement.removeElement2(new int[]{4,1,2,3,5},4);
    }
    /**
     * 双指针法，j判断是否与val一样，如果不一样，i右移一位，相当于把右边的值往左挪，最后返回i就好了
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                i++;
            }
        }
        return i;
    }

    /**
     * 双指针 —— 当要删除的元素很少时
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            if (nums[i] == val) {
                //因为没要求顺序，所以可以把左指针的值和右指针的值调换，然后右指针左移，实现去除元素的效果
                //也就是把值扔到末尾
                nums[i] = nums[j - 1];
                j--;
            } else {
                i++;
            }
        }
        return j;
    }
}
