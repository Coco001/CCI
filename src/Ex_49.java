/**
 * 有一堆箱子，每个箱子宽为wi，长为di，高为hi，现在需要将箱子都堆起来，
 * 而且为了使堆起来的箱子不到，上面的箱子的宽度和长度必须小于下面的箱子。
 * 请实现一个方法，求出能堆出的最高的高度，这里的高度即堆起来的所有箱子的高度之和。
 * 给定三个int数组w,l,h，分别表示每个箱子宽、长和高，同时给定箱子的数目n。
 * 请返回能堆成的最高的高度。保证n小于等于500。
 * 测试样例：
 * [1,1,1],[1,1,1],[1,1,1]
 * 返回：1
 */
public class Ex_49 {
    public static void main(String[] args) {
        int[] w = new int[]{2768,542,832,844,2920,587,72,1724,447,809,672,2393,1235,2775,273,1165,1809,111,1263,2751,1068,2507,453,65,2338,1103,1093,2327,1995,1125,2340,1133,2123,1692,2215,140,1822,2144,2240,2916,1860,2226,698,846,2177,295};
        int[] l = new int[]{821,2593,1581,2891,2853,1662,2747,2856,2178,865,383,523,809,998,312,237,1871,2730,823,676,568,1839,2063,1651,2704,2113,1316,2892,1874,270,1112,869,1099,1876,371,2298,2070,1514,2916,165,1043,1355,2852,1319,1979,1961};
        int[] h = new int[]{771,2963,1599,1910,2317,2884,872,2463,949,341,2718,1500,1071,539,2463,1355,104,2989,1240,240,981,0,2172,3011,621,681,1178,2518,2766,615,460,2399,2443,2894,799,1726,2454,2099,2279,2911,2018,426,2896,224,2663,351};
        System.out.println(getHeight01(w, l, h, 46));
    }


    public static int getHeight01(int[] w, int[] l, int[] h, int n) {
        // write code here
        sort(w, l, h, n);//首先按照箱子的宽度进行升序排序，然后按照箱子的长度求取最长递增子序列
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = h[i];//当前最小高度就是自身的高度
            for (int j = 0; j < i; j++) {
                if (l[j] < l[i] && dp[j] + h[i] > dp[i] && w[j] < w[i]) {
                    dp[i] = dp[j] + h[i];
                }
            }
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }
    //检查通过
    public static int getHeight(int[] w, int[] l, int[] h, int n) {
        // write code here
        sort(w, l, h, n);//首先按照箱子的宽度进行升序排序
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (l[j] < l[i] && w[j] < w[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += h[i];
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }

    private static void sort(int[] w, int[] l, int[] h, int n) {
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (w[i] > w[j]) {
                    swap(w, l, h, i, j);
                }
            }
        }
    }

    private static void swap(int[] w, int[] l, int[] h, int i, int j) {
        int tmp = w[i];
        w[i] = w[j];
        w[j] = tmp;
        tmp = l[i];
        l[i] = l[j];
        l[j] = tmp;
        tmp = h[i];
        h[i] = h[j];
        h[j] = tmp;
    }
}
