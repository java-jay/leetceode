package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt2("MCMXCIV"));
    }

    /**
     * 哈希表
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        //存入所有可能
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int ans = 0;
        for (int i = 0; i < s.length();) {
            //如果两个字符的组合能在map中找到
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                ans += map.get(s.substring(i, i + 2));
                i += 2;
            } else {//如果找不到，就计算单个字符
                ans += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return ans;
    }

    /**
     *
     前值小于后值，减去前值
     前值大于或等于后值，加上前值
     最后一个值必然是加上的
     * @param s
     * @return
     */
    public static int romanToInt2(String s) {
        int sum = 0;
        //获取前值
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            //获取后值
            int num = getValue(s.charAt(i));
            //如果前值更小，说明是后面的值-前面的值，如IV为5-1，所以总值先减前值
            if(preNum < num) {
                sum -= preNum;
            } else {//如果前值更大，说明是后面的值+前面的值，所以总值先加前值
                sum += preNum;
            }
            //当前值成为前值
            preNum = num;
        }
        //最后一个值必定为加，总值加上最后的前值
        sum += preNum;
        return sum;
    }

    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

}
