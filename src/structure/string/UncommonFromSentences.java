package structure.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 884. 两句话中的不常见单词
 */
public class UncommonFromSentences {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String,Integer> count=new HashMap<>();
        //遍历字符串中的单词，并统计单词出现次数
        for (String word : A.split(" ")) {
            //如果当前单词不存在，就默认存入0
            count.put(word,count.getOrDefault(word,0)+1);
        }
        for (String word : B.split(" ")) {
            count.put(word,count.getOrDefault(word,0)+1);
        }
        List<String> list=new ArrayList<>();
        //输出出现次数只有1次的单词
        for (String word : count.keySet()) {
            if(count.get(word)==1){
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }
}
