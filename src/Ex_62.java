/**
 * 请设计一个算法，计算n的阶乘有多少个尾随零。
 * 给定一个int n，请返回n的阶乘的尾零个数。保证n为正整数。
 * 测试样例：
 * 5
 * 返回：1
 */
public class Ex_62 {
    public int getFactorSuffixZero(int n) {
        // write code here
        if (n < 0) {
            return -1;
        }
        int count = 0;
        for (int i = 5; n / i > 0; i *= 5) {//统计该数中包含几个5的倍数；几个25的倍数；几个125的倍数……
            count += n / i;
        }
        return count;
    }
}
