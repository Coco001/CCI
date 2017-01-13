/**
 * 有一个排过序的字符串数组，但是其中有插入了一些空字符串，3
 * 请设计一个算法，找出给定字符串的位置。算法的查找部分的复杂度应该为log级别。
 * 给定一个string数组str,同时给定数组大小n和需要查找的string x，请返回该串的位置(位置从零开始)。
 * 测试样例：
 * ["a","b","","c","","d"],6,"c"
 * 返回：3
 */
public class Ex_54 {
    public static void main(String[] args) {
        String[] test = new String[]{"a", "b", "", "c", "", "d"};
        System.out.println(findString(test, 6, "c"));
    }

    public static int findString(String[] str, int n, String x) {
        // write code here
        int left = 0;
        int right = n - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            int cmp = 0;
            if (str[mid].equals("")) {
                //同时向左右寻找距离最近的一个非空字符串
                int l = mid - 1;
                int r = mid + 1;
                while (true) {
                    if (l < left && r > right) {
                        return -1;
                    } else if (r < right && !str[r].equals("")) {
                        mid = r;
                        break;
                    } else if (l > left && !str[l].equals("")) {
                        mid = l;
                        break;
                    }
                    l--;
                    r++;
                }
            }

            cmp = str[mid].compareTo(x);
            if (cmp == 0) {
                return mid;
            }
            if (cmp < 0) {//向右侧寻找
                left = mid + 1;
            } else {//向左侧寻找
                right = mid - 1;
            }
        }
        return mid;
    }
}
