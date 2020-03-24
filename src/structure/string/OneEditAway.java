package structure.string;

/**
 * @Auther java_jay
 * @Date 2020/3/24
 */
public class OneEditAway {
    public boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }
        //替换的情况
        if (len1 == len2) {
            int count = 0;
            for (int i = 0; i < len1; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    count++;
                }
                if (count > 1) {
                    return false;
                }
            }
        } else {
            //增加或删除的情况
            int count = 0;
            for (int i = 0, j = 0; i < len1 && j < len2; i++, j++) {
                if (first.charAt(i) != second.charAt(j)) {
                    count++;
                    if (len1 > len2) {
                        i++;
                    } else {
                        j++;
                    }
                }
                if (count > 1 || first.charAt(i) != second.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
