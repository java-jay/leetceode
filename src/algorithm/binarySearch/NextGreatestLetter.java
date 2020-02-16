package algorithm.binarySearch;

/**
 * 744. 寻找比目标字母大的最小字母
 */
public class NextGreatestLetter {
    public static void main(String[] args) {
        char[] chars = {'a', 'b'};
        new NextGreatestLetter().nextGreatestLetter(chars, 'z');
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            char c = letters[mid];
            if (c <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //因为数组里字母的顺序是循环的，所以取余数
        return letters[right % letters.length];
    }
}

