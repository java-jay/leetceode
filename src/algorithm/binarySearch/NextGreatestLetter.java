package algorithm.binarySearch;

/**
 * 744. 寻找比目标字母大的最小字母
 */
public class NextGreatestLetter {
    public static void main(String[] args) {
        char[] chars = {'a', 'b'};
        new NextGreatestLetter().nextGreatestLetter(chars,'z');
    }
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        //因为数组里字母的顺序是循环的，所以取余数
        return letters[low % letters.length];


    }
}
