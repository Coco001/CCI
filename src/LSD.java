/**
 * 低位优先字符串排序
 */
public class LSD {
    /**
     * 通过低位的W个字符对字符串排序
     * @param a 需要排序的字符串
     * @param w 低几位
     */
    private static void sort(String[] a, int w) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for (int i = w; i >= 0; i++) {
            int[] count = new int[R + 1];
            for (int j = 0; j < N; j++) {// 统计词频
                count[a[j].charAt(i) + 1]++;
            }
            for (int j = 0; j < R; j++) {// 将词频转换成索引
                count[j + 1] += count[j];
            }
            for (int j = 0; j < N; j++) {// 将元素分类
                aux[count[a[j].charAt(i)]++] = a[j];
            }
            for (int j = 0; j < N; j++) {// 回写
                a[j] = aux[j];
            }
        }
    }
}
