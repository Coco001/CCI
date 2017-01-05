import java.net.FileNameMap;

/**
 * 高位优先字符串排序
 */
public class MSD {
    private static int R = 256;// 基数
    private static final int M = 15;// 小数组的切换阈值
    private static String[] aux;// 数据分类的辅助数组

    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        } else {
            return -1;
        }
    }
    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        // 以d个字符为键将a[lo]至a[hi]排序
        if (hi <= lo + M) {
            sort(a, lo, hi, d);
            return;
        }
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {// 计算词频
            count[charAt(a[i],d)+2]++;
        }
        for (int i = 0; i < R + 1; i++) {// 将词频转换成索引
            count[i + 1] += count[i];
        }
        for (int i = lo; i <= hi; i++) {// 数据分类
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }
        for (int i = lo; i <= hi; i++) {// 回写
            a[i] = aux[i - lo];
        }
        for (int i = 0; i < R; i++) {// 递归的以每个字符为键进行排序
            sort(a, lo + count[i], lo + count[i + 1] - 1, d + 1);
        }
    }
}
