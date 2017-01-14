/**
 * 现在我们要读入一串数，同时要求在读入每个数的时候算出它的秩，
 * 即在当前数组中小于等于它的数的个数(不包括它自身)，请设计一个高效的数据结构和算法来实现这个功能。
 * 给定一个int数组A，同时给定它的大小n，请返回一个int数组，元素为每次加入的数的秩。保证数组大小小于等于5000。
 * 测试样例：
 * [1,2,3,4,5,6,7],7
 * 返回：[0,1,2,3,4,5,6]
 */
public class Ex_58 {
    public static void main(String[] args) {
        int[] text = new int[]{147,223,144,252,205,278,281};
        getRankOfNumber(text, 7);
    }
    public static int[] getRankOfNumber(int[] A, int n) {
        // write code here
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i]++;
                }
            }
        }
        return dp;
    }
}
