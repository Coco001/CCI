/**
 * 请编写一个方法，找出两个数字中最大的那个。条件是不得使用if-else等比较和判断运算符。
 * 给定两个int a和b，请返回较大的一个数。若两数相同则返回任意一个。
 * 测试样例：
 * 1，2
 * 返回：2
 */
public class Ex_60 {

    public static void main(String[] args) {
        System.out.println(sign(1)); // 1
        System.out.println(1>>31);   // 0
        System.out.println(sign(-1));// 0
        System.out.println(-1>>31);  // -1
    }
    //有可能溢出
    private static int getMax01(int a, int b) {
        int c = (a - b) >> 31;
        return a + c * (a - b);
    }

    private static int getMax(int a, int b) {
        int c = a - b;
        int sa = sign(a);//a为正数得到1，为负数得到0
        int sb = sign(b);//b为正数得到1，为负数得到0
        int sc = sign(c);//a-b为正数得到1，为负数得到0
        int useSignA = sa ^ sb;//a、b符号不同为1，相同为0
        int useSignC = flip(sa ^ sb);//ab的符号相同就得到1，符号不同就得到0
        int k = useSignA * sa + useSignC * sc;
        int q = flip(k);
        return a * k + b * q;
    }

    // n 为正数返回 1，n 为负数返回0
    private static int sign(int n) {//获取n的符号位，一个数右移31位后&1表示获取该数的符号位
        return flip((n >> 31) & 1);
    }

    // 1 变 0， 0 变 1
    private static int flip(int n) {
        return n ^ 1;
    }

}
