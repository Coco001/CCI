/**
 * 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。
 * 请实现一个方法，计算小孩有多少种上楼的方式。为了防止溢出，请将结果Mod 1000000007
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 * 测试样例：
 * 1
 * 返回：1
 */
public class Ex_38 {
    public int countWays(int n) {
        // write code here
        int f = 1, s = 2, t = 4;
        int res = 0;
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }

        for (int i = 4; i <= n; i++) {
            res = ((f + s) % 1000000007 + t) % 1000000007;
            f = s;
            s = t;
            t = res;
        }
        return res;
    }
}
