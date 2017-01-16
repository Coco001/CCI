/**
 * 请编写一个函数，将两个数字相加。不得使用+或其他算数运算符。
 * 给定两个int A和B。请返回A＋B的值
 * 测试样例：
 * 1,2
 * 返回：3
 */
public class Ex_69 {
    public int addAB(int A, int B) {
        // write code here
        if (B == 0) {
            return A;
        }
        int sum = A ^ B;//相加但不进位
        int carry = (A & B) << 1;//进位但不想加
        return addAB(sum, carry);//递归调用
    }
}
