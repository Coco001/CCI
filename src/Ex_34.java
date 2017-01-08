
/**
 * 请编写一个方法，实现整数的乘法、减法和除法运算(这里的除指整除)。只允许使用加号。
 * 给定两个正整数int a,int b,同时给定一个int type代表运算的类型，
 * 1为求a ＊ b，0为求a ／ b，-1为求a － b。请返回计算的结果，保证数据合法且结果一定在int范围内。
 * 测试样例：
 * 1,2,1
 * 返回：2
 */
public class Ex_34 {
    public static void main(String[] args) {
        System.out.println(calc(7133, 7371, 1));
    }
    public static int calc(int a, int b, int type) {
        // write code here
        switch (type) {
            case -1:
                return minus(a, b);
            case 0:
                return division(a, b);
            case 1:
                return product(a, b);
            default:
                System.out.println("Error input");
                return 0;
        }
    }

    private static int minus(int a, int b) {
        int tmp = ~b + 1;
        return a + tmp;
    }

    private static int division(int a, int b) {
        int tmp = ~b + 1;
        int count = 0;
        while (a > 0) {
            a += tmp;
            if (a > 0) {
                count++;
            }
        }
        return count;
    }

    private static int product(int a, int b) {
        int tmp = ~b + 1;
        int res = 0;
        while (tmp++ < 0) {
            res += a;
        }
        return res;
    }
}
