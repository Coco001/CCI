import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 现有一个字典，同时给定字典中的两个字符串s和t，给定一个变换，每次可以改变字符串中的任意一个字符，
 * 请设计一个算法，计算由s变换到t所需的最少步数，同时需要满足在变换过程中的每个串都是字典中的串。
 * 给定一个string数组dic，同时给定数组大小n，串s和串t，请返回由s到t变换所需的最少步数。
 * 若无法变换到t则返回-1。保证字符串长度均小于等于10，且字典中字符串数量小于等于500。
 * 测试样例：
 * ["abc","adc","bdc","aaa”],4,”abc","bdc"
 * 返回：2
 */
public class Ex_77 {
/*    static class Node{
        String string;
        boolean flag;

        public Node(String string, boolean flag) {
            this.string = string;
            this.flag = flag;
        }
    }*/

    public static void main(String[] args) {
        String[] test = new String[]{"bb","ai","ab","ba","aa","bb","aa","lwn","bi","aa","aa","ba","bb","ti","ab","ba","ai","bb","ab","ab","ba","cmm"};
        String[] test1 = new String[]{"vvz","bbaa","f","bbba","bbaa","baoa","btoa","bbba","dcki","bbbb","ge","atoj","baaa","btoj","ae"};
        String[] test2 = new String[]{"ph","b","ibl","na","a","a","b","a","b","a","b","a","j"};
        String[] test3 = new String[]{"byba","lwr","baab","rybb","aaaa","baaa","ryba","baab","ca","izv","ayba","ryac","baaa","ryaa","babb","baaa","aybb","bbab","baba","ryqc","vba","baab"};
        System.out.println(countChanges(test3, test3.length, "ryqc", "bbab"));
    }

    private static HashMap<String, ArrayList<String>> map;
    private static int countChanges(String[] dic, int n, String s, String t) {
        // write code here
        if (s.equals(t)) {
            return 0;
        }
        buildMap(dic, n, s);
        return BFS(s, t);
    }

    private static int BFS(String s, String t) {
        LinkedList<String> queue = new LinkedList<>();
        ArrayList<String> list;
        ArrayList<String> per = new ArrayList<>();//存放遍历过的字符串
        String tmpS;
        queue.add(s);
        queue.add("###");
        int count = 1;

        while (!queue.isEmpty()) {
            tmpS = queue.poll();
            if (tmpS.equals("###")) {
                count++;
                continue;
            }
            per.add(tmpS);//存放遍历过的字符串
            list = map.get(tmpS);
            for (String str : list) {
                if (per.contains(str)) {
                    continue;
                }
                if (str.equals(t)) {
                    return count;
                }
                if (!queue.contains(str)) {
                    queue.add(str);
                }
            }
            if (queue.peek().equals("###")) {//上一层所有的元素遍历完之后才添加新的分层标识
                queue.add("###");
            }
        }
        return count;
    }

    //构建邻接矩阵
    private static void buildMap(String[] dic, int n, String org) {
        map = new HashMap<>();
        ArrayList<String> list;
        String tmp;
        for (int i = 0; i < n; i++) {
            tmp = dic[i];
            if (tmp.length() != org.length()) {
                continue;
            }
            list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (check(tmp, dic[j]) && !list.contains(dic[j])) {
                    list.add(dic[j]);
                }
            }
            map.put(tmp, list);
        }
    }

    private static boolean check(String s1, String s2) {
        if (s1.length() != s2.length() || s1.equals(s2)) {
            return false;
        }

        int num = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                num++;
            }
            if (num > 1) {
                return false;
            }
        }
        return num != 0;
    }
}
