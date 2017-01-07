/**
 * 请编写程序交换一个数的二进制的奇数位和偶数位。（使用越少的指令越好）
 * 给定一个int x，请返回交换后的数int。
 * 测试样例：
 * 10
 * 返回：5
 */
public class Ex_29 {
    public int exchangeOddEven(int x) {
        // write code here
        int odd = x & 0xAAAAAAAA;
        int even = x & 0x55555555;
        return odd >> 1 + even << 1;
    }
}
