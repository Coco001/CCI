import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 请编写一个方法，对一个字符串数组进行排序，将所有变位词合并，保留其字典序最小的一个串。
 * 这里的变位词指变换其字母顺序所构成的新的词或短语。例如"triangle"和"integral"就是变位词。
 * 给定一个string的数组str和数组大小int n，请返回排序合并后的数组。保证字符串串长小于等于20，数组大小小于等于300。
 * 测试样例：
 * ["ab","ba","abc","cba"]
 * 返回：["ab","abc"]
 */
public class Ex_52 {
    public ArrayList<String> sortStrings(String[] str, int n) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        String cur;
        for (int i = 0; i < n; i++) {
            cur = str[i];
            cur = getMin(str, cur);
            if (!res.contains(cur)) {
                res.add(cur);
            }
        }
        Collections.sort(res);
        return res;
    }

    private String getMin(String[] str, String cur) {
        int len = cur.length();
        for (int i = 0; i < str.length; i++) {
            if (len == str[i].length()&&comp(cur,str[i])) {
                cur = cur.compareTo(str[i]) > 0 ? str[i] : cur;
            }
        }
        return cur;
    }

    private boolean comp(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        char[] c2 = s2.toCharArray();
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}
