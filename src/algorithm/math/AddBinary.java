package algorithm.math;

/**
 * 67. 二进制求和
 * 整体思路是将两个字符串较短的用0补齐，使得两个字符串长度一致，然后从末尾进行遍历计算，得到最终结果
 *
 * 从右往左相加，把每次相加后的值加入字符串中，最后如果还有进位，就将它加到末尾，然后反转字符串
 */
public class AddBinary {
    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        addBinary.addBinary("11", "1");
    }

    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        //从后往前遍历
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            //让当前值为进位
            int sum = ca;
            //因为字符长度可能不一样，当索引为负数时，当做加了个0
            sum += (i >= 0 ? a.charAt(i) - '0' : 0);
            sum += (j >= 0 ? b.charAt(j) - '0' : 0);
            ans.append(sum % 2);//将计算后的当前位加入字符串
            ca = sum / 2;//进位
        }
        //如果最后还有进位，就将它加入字符串中
        ans.append(ca == 1 ? ca : "");
        //由于是从右往左遍历，所以最后要逆转
        return ans.reverse().toString();
    }
}