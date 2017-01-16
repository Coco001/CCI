/**
 * 请编写一个方法，输出0到n(包括n)中数字2出现了几次。
 * 给定一个正整数n，请返回0到n的数字中2出现了几次。
 * 测试样例：
 * 10
 * 返回：1
 */
public class Ex_70 {

    public static void main(String[] args) {
        System.out.println(countNumberOf2s(102));
    }
    public static int countNumberOf2s(int n) {
        int count = 0;
        int len = String.valueOf(n).length();
        for (int i = 0; i < len; i++) {
            count += count2s(n, i);
        }
        return count;
    }

    private static int count2s(int n, int d) {
        int powOf10 = (int) Math.pow(10, d);
        int nextPowOf10 = powOf10 * 10;
        int right = n % powOf10;
        int roundDown = n - n % nextPowOf10;
        int roundUp = roundDown + nextPowOf10;
        int digit = (n / powOf10) % 10;
        if (digit < 2) {
            return roundDown / 10;
        } else if (digit == 2) {
            return roundDown / 10 + right + 1;
        } else {
            return roundUp / 10;
        }
    }

    private int countNumberOf2s03(int n) {
        int cnt = 0, k = 0;
        for (int i = 1;(k = n / i)>0;i *= 10) {
            // k / 10 为高位的数字。
            cnt += (k / 10) * i;
            // 当前位的数字。
            int cur = k % 10;
            if (cur > 2) {
                cnt += i;
            } else if (cur == 2) {
                // n - k * i 为低位的数字。
                cnt += n - k * i + 1;
            }
        }
        return cnt;
    }

    public int countNumberOf2s02(int n) {
        int result = 0;
        for (int i = 1; i <= n; i *= 10) {
            result += (n / i + 7) / 10 * i + (n / i % 10 == 2 ? n % i + 1 : 0);
        }
        return result;
    }

    //内存过大
    public int countNumberOf2s01(int n) {
        // write code here
        int[] temp = new int[n + 1];
        temp[2] = 1;
        int sum = 1;
        for (int i = 10; i <= n; i++) {
            int b = i % 10;
            int a = i / 10;
            if (b == 2) {
                temp[i] = temp[a] + 1;
                sum = sum + temp[i];
            } else {
                temp[i] = temp[a];
                sum = sum + temp[a];
            }
        }
        return sum;
    }
}
