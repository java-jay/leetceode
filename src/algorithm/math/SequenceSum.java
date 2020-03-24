package algorithm.math;

import java.util.Scanner;

/**
 * @Auther java_jay
 * @Date 2020/3/19
 */
public class SequenceSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int L = in.nextInt();
            //i为序列的元素的个数
            for (int i = L; i <= 100; i++) {
                //等差数列求和公式的变换，差值为1，求a1的值
                //原公式为N=(a1+(n-1)*d+a1)*n/2
                //n从i的取值范围中确定
                if ((2 * N + i - i * i) % (2 * i) == 0) {
                    //a1为序列的第一个数
                    int a1 = (2 * N + i - i * i) / (2 * i);
                    //j用来确定序列后面的数
                    for (int j = 0; j < i - 1; j++) {
                        int a = a1 + j;
                        System.out.print(a + " ");
                    }
                    //加上i-1
                    System.out.println(a1 + i - 1);
                    break;
                }
            }
            System.out.println("No");
        }
    }
}