import java.util.HashMap;

/**
 * 请设计一个高效的方法，找出任意指定单词在一篇文章中的出现频数。
 * 给定一个string数组article和数组大小n及一个待统计单词word，请返回该单词在文章中的出现频数。保证文章的词数小于等于1000。
 */
public class Ex_66 {
    public int getFrequency(String[] article, int n, String word) {
        // write code here
        HashMap<String, Integer> map = new HashMap<>();
        String tmp;
        int count;
        for (int i = 0; i < n; i++) {
            tmp = article[i].toLowerCase();
            count = 1;
            if (map.containsKey(tmp)) {
                count = map.get(tmp) + 1;
            }
            map.put(tmp, count);
        }

        return map.containsKey(word) ? map.get(word) : 0;
    }
}
