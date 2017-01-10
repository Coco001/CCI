import java.util.ArrayList;
import java.util.Collections;

/**
 * 编写一个方法，确定某字符串的所有排列组合。
 * 给定一个string A和一个int n,代表字符串和其长度，请返回所有该字符串字符的排列，
 * 保证字符串长度小于等于11且字符串中字符均为大写英文字符，排列中的字符串按字典序从大到小排序。(不合并重复字符串)
 * 测试样例：
 * "ABC"
 * 返回：["CBA","CAB","BCA","BAC","ACB","ABC"]
 */
public class Ex_44 {
    public static void main(String[] args) {
        String test = "ABC";
        getPermutation(test);
    }
    public static ArrayList<String> getPermutation(String A) {
        // write code here
        ArrayList<String> per = new ArrayList<>();
        ArrayList<String> cur = new ArrayList<>();
        int n = A.length();

        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            cur.clear();
            if (!per.isEmpty()) {
                for (String s : per) {
                    cur.addAll(merge(s, c));
                }
            } else {
                cur.add(c + "");
            }
            per = new ArrayList<>();
            per.addAll(cur);
        }
        //对结果进行排序
        Collections.sort(cur);
        Collections.reverse(cur);

        return cur;
    }

    private static ArrayList<String> merge(String s, char c) {
        ArrayList<String> combins = new ArrayList<>();
        String left, right;
        combins.add(c + s);
        for (int i = 0; i < s.length(); i++) {
            left = s.substring(0, i+1);
            right = s.substring(i+1, s.length());
            combins.add(left + c + right);
        }
//        combins.add(s + c);
        return combins;
    }
}
