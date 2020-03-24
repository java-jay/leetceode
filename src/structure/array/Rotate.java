package structure.array;

/**
 * @Auther java_jay
 * @Date 2020/3/24
 */
public class Rotate {
    /**
     * nextX = currentY，nextY = n - 1 - currentX
     * 每四个点四个点的更新。
     * 以示例一为例[
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * ]
     * 把1移动到3的位置，3移动到9的位置，9移动到7的位置，7移动到1的位置。
     * 如此只要对第一行的前N-1个元素进行如此操作，最外圈已经更新好了。
     * 如此依次对每一圈进行该操作即可。
     */
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        //i为横坐标，j为纵坐标，左下角为原点，和右上角的对角线的值交换
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                int swap = matrix[i][j];
                matrix[i][j] = matrix[size - j - 1][size - i - 1];
                matrix[size - j - 1][size - i - 1] = swap;
            }
        }
        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size; j++) {
                int swap = matrix[i][j];
                matrix[i][j] = matrix[size - i - 1][j];
                matrix[size - i - 1][j] = swap;
            }
        }
    }
}
